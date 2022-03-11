package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        String errorMsg = null;
        if (StringUtils.hasText(student.getStudentNumber()) == false)
            errorMsg = "학번을 입력하세요";
        else if (StringUtils.hasText(student.getName()) == false)
            errorMsg = "이름을 입력하세요";
        else if (student.getYear() == 0)
            errorMsg = "학년을 입력하세요";
        else {
            try {
                studentMapper.insert(student);
                return "redirect:list";
            } catch (Exception e) {
                errorMsg = "저장실패: " + e.getMessage();
            }
        }
        model.addAttribute("errorMsg", errorMsg);
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
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
        String errorMsg = null;
        if (StringUtils.hasText(student.getStudentNumber()) == false)
            errorMsg = "학번을 입력하세요";
        else if (StringUtils.hasText(student.getName()) == false)
            errorMsg = "이름을 입력하세요";
        else if (student.getYear() == 0)
            errorMsg = "학년을 입력하세요";
        else {
            try {
                studentMapper.update(student);
                return "redirect:list";
            } catch (Exception e) {
                errorMsg = "저장실패: " + e.getMessage();
            }
        }
        model.addAttribute("errorMsg", errorMsg);
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @RequestMapping("student/delete")
    public String delete(Model model, int id, RedirectAttributes attributes) {
        try {
            studentMapper.delete(id);
            return "redirect:list";
        } catch (Exception e) {
            attributes.addFlashAttribute("errorMsg", "삭제실패: " + e.getMessage());
            return "redirect:edit?id=" + id;
        }
    }
}

