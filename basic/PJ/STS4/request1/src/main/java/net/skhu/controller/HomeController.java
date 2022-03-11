package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
    @GetMapping("homework/test1")
    public String test1(Model model) {
    	model.addAttribute("num1", 0);
        return "homework/test1";
    }

    @PostMapping("homework/test1")
    public String test1(Model model, Integer num1) {
        model.addAttribute("num1", plus(num1));
        return "homework/test1";
    }
    public int plus(int num1) {
    	return num1+1;
    }

    @GetMapping("homework/test2")
    public String test2(Model model) {
    	model.addAttribute("cmd", "one");
        return "homework/test2";
    }

    @PostMapping("homework/test2")
    public String test2(Model model, String cmd) {
        model.addAttribute("cmd", cmd);
        return "homework/test2";
    }
}
