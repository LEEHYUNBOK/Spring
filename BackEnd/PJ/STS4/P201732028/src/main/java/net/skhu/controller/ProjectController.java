package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Project;
import net.skhu.entity.Manager;
import net.skhu.repository.ManagerRepository;
import net.skhu.repository.ProjectRepository;

@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired ProjectRepository projectRepository;
    @Autowired ManagerRepository managerRepository;

    @RequestMapping("list")
    public String list(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "project/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Project project = new Project();
        List<Manager> managers= managerRepository.findAll();
        model.addAttribute("project", project);
        model.addAttribute("managers", managers);
        return "project/edit";
    }

    @PostMapping("create")
    public String create(Model model, Project project) {
        projectRepository.save(project);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Project project = projectRepository.findById(id).get();
        List<Manager> managers = managerRepository.findAll();
        model.addAttribute("project", project);
        model.addAttribute("managers", managers);
        return "project/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Project project) {
        projectRepository.save(project);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        projectRepository.deleteById(id);
        return "redirect:list";
    }
}
