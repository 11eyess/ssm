package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();

    void save(Student student);

    public Student findById(int id);

    public void update(Student student);

    public void delete(int id);
}
