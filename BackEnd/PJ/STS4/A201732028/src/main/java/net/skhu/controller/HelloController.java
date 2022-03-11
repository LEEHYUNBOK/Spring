package net.skhu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("id", 201732028);
        model.addAttribute("name", "이현복");
        model.addAttribute("now", new Date());
        return "hello/index";
    }
}
