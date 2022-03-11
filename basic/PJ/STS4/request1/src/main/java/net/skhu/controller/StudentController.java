package net.skhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;

@Controller
public class StudentController {
	
    @GetMapping("student/edit")
    public String register2(Model model) {
        return "student/edit";
    }

    @PostMapping("student/edit")
    public String register2(Model model, HttpSession session, Student student)
    {
        String errorMsg = null;
        if (student.getStudentNo() == null || student.getStudentNo().length() == 0)
            errorMsg = "학번을 입력하세요";
        else if (student.getName() == null || student.getName().length() == 0)
            errorMsg = "이름을 입력하세요";
        else if (student.getDepartmentId() == 0)
            errorMsg = "전공을 선택하세요";
        else if (student.getEmail() == null || student.getEmail().length() == 0)
            errorMsg = "이메일 주소를 입력하세요";
        else {
            session.setAttribute("student", student);
            return "redirect:edit_success";
        }
        model.addAttribute("student", student);
        model.addAttribute("errorMsg", errorMsg);
        return "student/edit";
    }

    @RequestMapping("student/edit_success")
    public String edit_success(Model model) {
        return "student/edit_success";
    }
}
