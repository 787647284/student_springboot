package com.qf.service.impl;

import com.qf.dao.ClassMapper;
import com.qf.entity.Classes;
import com.qf.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    ClassMapper classMapper;

    @Override
    public Classes getById(int id) {
        return classMapper.selectById(id);
    }

    @Override
    public List<Classes> getlist() {
        List<Classes> classes = classMapper.selectList(null);
        return classes;
    }
}
