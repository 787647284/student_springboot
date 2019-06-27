package com.qf.service.impl;

import com.qf.dao.ClassMapper;
import com.qf.dao.StuMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.ClassesService;
import com.qf.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    StuMapper stuMapper;
    @Autowired
    ClassesService classesService;
    @Override
    public List<Student> getlist() {
        List<Student> students = stuMapper.selectList(null);
        for (Student student : students) {
            //利用学生所属的班级id  找到对应的班级
            Classes classes = classesService.getById(student.getCid());
            student.setClasses(classes);
        }
        return students;


    }


    public void delete(Integer id) {
        System.out.println("执行了");
        System.out.println(id);
        stuMapper.deleteById(id);
    }

    @Override
    public void addstu(Student student) {
        stuMapper.insert(student);
    }
}
