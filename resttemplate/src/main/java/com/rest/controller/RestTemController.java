package com.rest.controller;

import com.rest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestTemController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/loadAll")
    public Collection<Student> load(){
       return restTemplate.getForEntity("http://localhost:8010/loadAll", Collection.class).getBody();
    }


    @GetMapping("/get/{id}")
    private Student get(@PathVariable("id") long id){
        return  restTemplate.getForEntity("http://localhost:8010/get/{id}",Student.class,id).getBody();
    }


    @PostMapping("/update")
    private void seveOrUpdate(@RequestBody Student stu){
       restTemplate.postForEntity("http://localhost:8010/update",stu,null).getBody();
    }


    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/delete",id);
    }

}
