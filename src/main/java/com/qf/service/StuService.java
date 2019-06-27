package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface StuService {
    public List<Student> getlist();

    void delete(Integer id);

    void addstu(Student student);
}
