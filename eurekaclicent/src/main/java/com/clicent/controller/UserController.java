package com.clicent.controller;

import com.clicent.dao.impl.UserDaoImpl;
import com.clicent.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController //传入为json格式
public class UserController {


    @Autowired
    private UserDaoImpl udi;

    @GetMapping("/loadAll")
    public Collection<Student> load(){
      return  udi.loadAll();
    }


    @GetMapping("/get/{id}")
    private Student get(@PathVariable("id") long id){
        return  udi.getById(id);
    }


    @PostMapping("/update")
    private void seveOrUpdate(@RequestBody Student stu){
        udi.seveOrUpdate(stu);
    }



    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id){
        udi.dalete(id);
    }

}
