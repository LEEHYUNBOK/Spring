package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
public class StudentController {

    @Autowired StudentMapper studentMapper;
    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("student/list")
    public String list(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("student/create")
    public String create(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping("student/create")
    public String create(Model model, Student student) {
        studentMapper.insert(student);
        return "redirect:list";
    }

    @GetMapping("student/edit")
    public String edit(Model model, int id) {
        Student student = studentMapper.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping("student/edit")
    public String edit(Model model, Student student) {
        studentMapper.update(student);
        return "redirect:list";
    }
    
    @RequestMapping("student/delete")
    public String delete(int id) {
        studentMapper.delete(id);
        return "redirect:list";
    }

}

