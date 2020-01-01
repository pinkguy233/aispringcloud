package com.clicent.dao;




import com.clicent.entity.Student;

import java.awt.*;
import java.util.Collection;

public interface UserDao {

   Collection<Student> loadAll();

   Student getById(Long id);

   void seveOrUpdate(Student stu);

   void dalete(long id);

}
