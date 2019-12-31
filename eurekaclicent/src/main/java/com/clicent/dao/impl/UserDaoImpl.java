package com.clicent.dao.impl;

import com.clicent.dao.UserDao;
import com.clicent.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao{

    private static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1L,new Student(1L,"刘波",15));
        studentMap.put(2L,new Student(2L,"洲书院",1475));
        studentMap.put(3L,new Student(3L,"上级领导",15));

    }

    @Override
    public Collection<Student> loadAll() {

        return studentMap.values();
    }

    @Override
    public Student getById(Long id) {
        return studentMap.get(id);
    }

    @Override
    public void seveOrUpdate(Student stu) {
        studentMap.put(stu.getId(),stu);
    }

    @Override
    public void dalete(long id) {
        studentMap.remove(id);
    }
}
