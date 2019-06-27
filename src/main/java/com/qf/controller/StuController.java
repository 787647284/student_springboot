package com.qf.controller;

import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.ClassesService;
import com.qf.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Autowired
    StuService stuService;
    @Autowired
    ClassesService classesService;


    @RequestMapping("/list")
    public String list(Model model){
        System.out.println("方法执行了");
        List<Student> students = stuService.getlist();
        model.addAttribute("stus",students);
        System.out.println(students);
        return "stulist";
    }
    @RequestMapping("/delete")
    public String delete(Integer id ){
        System.out.println("删除执行了");
        System.out.println(id);
        stuService.delete(id);
        return "redirect:/stu/list";
    }
    @RequestMapping("/toadd")
    public String toadd(Model model){
        List<Classes> getlist =classesService.getlist();
        model.addAttribute("classes",getlist);
        return "stuadd";
    }
    @RequestMapping("insert")
    public  String insert(Student student){
        stuService.addstu(student);
        return "redirect:/stu/list";
    }

}
