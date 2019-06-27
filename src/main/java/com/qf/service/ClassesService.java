package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

public interface ClassesService {
    Classes getById(int id);

    List<Classes> getlist();
}
