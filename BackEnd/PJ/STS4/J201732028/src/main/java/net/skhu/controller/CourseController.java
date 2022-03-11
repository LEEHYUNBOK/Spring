package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.CourseMapper;

@Controller
@RequestMapping("course")
public class CourseController {
	@Autowired CourseMapper coursemapper;
	
	@RequestMapping("list")
	public String list(Model model) {
        model.addAttribute("courses", coursemapper.findAll());
        return "course/list";
    }
}
