package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.StudentMapper;

@Controller
public class StudentController {

    @Autowired StudentMapper studentMapper;

    @RequestMapping("student/list")
    public String list(Model model) {
        model.addAttribute("students", studentMapper.findAll());
        return "student/list";
    }

    @RequestMapping("student/list1")
    public String list1(Model model, String srchText) {
        if (srchText == null) srchText = "";
        model.addAttribute("students", studentMapper.findByName(srchText + "%"));
        model.addAttribute("srchText", srchText);
        return "student/list1";
    }
    
    @RequestMapping("student/detail")
    public String detail(Model model, Integer id) {
        if (id == null) id = 4;
        model.addAttribute("student", studentMapper.findById(id));
        return "student/detail";
    }
    
    @RequestMapping("student/test1")
    public String test1(Model model) {
    	return "student/test1";
    }

    @RequestMapping("student/list2")
    public String list2(Model model, String srchText) {
        if (srchText == null) srchText = "";
        model.addAttribute("students", studentMapper.findByName(srchText + "%"));
        model.addAttribute("srchText", srchText);
        return "student/list2";
    }
    
    @RequestMapping("student/list3")
    public String list3(Model model, String srchText) {
        if (srchText == null) srchText = "";
        model.addAttribute("students", studentMapper.findByName(srchText + "%"));
        model.addAttribute("srchText", srchText);
        return "student/list3";
    }

}

