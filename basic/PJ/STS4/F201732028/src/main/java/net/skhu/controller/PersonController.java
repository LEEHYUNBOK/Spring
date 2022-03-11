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

import net.skhu.dto.Person;
import net.skhu.mapper.CategoryMapper;
import net.skhu.mapper.PersonMapper;

@Controller
public class PersonController {

	@Autowired
	PersonMapper personMapper;
	@Autowired
	CategoryMapper categoryMapper;

	@RequestMapping("person/list")
	public String list(Model model) {
		List<Person> persons = personMapper.findAll();
		model.addAttribute("persons", persons);
		return "person/list";
	}

	@GetMapping("person/create")
	public String create(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		model.addAttribute("categorys", categoryMapper.findAll());
		return "person/edit";
	}

	@PostMapping("person/create")
	public String create(Model model, Person person) {
		String errorMsg = null;
		if (StringUtils.hasText(person.getName()) == false)
			errorMsg = "이름을 입력하세요";
		else if (StringUtils.hasText(person.getSex()) == false)
			errorMsg = "성별을 선택하세요";
		else if (StringUtils.hasText(person.getPhone()) == false)
			errorMsg = "전화번호를 입력하세요";
		else if (StringUtils.hasText(person.getEmail()) == false)
			errorMsg = "이메일을 입력하세요";
		else {
			try {
				personMapper.insert(person);
				return "redirect:list";
			} catch (Exception e) {
				errorMsg = "저장실패: " + e.getMessage();
			}
		}
		model.addAttribute("errorMsg", errorMsg);
		model.addAttribute("categorys", categoryMapper.findAll());
		return "person/edit";
	}

	@GetMapping("person/edit")
	public String edit(Model model, int id) {
		Person person = personMapper.findById(id);
		model.addAttribute("person", person);
		model.addAttribute("categorys", categoryMapper.findAll());
		return "person/edit";
	}

	@PostMapping("person/edit")
	public String edit(Model model, Person person) {
		String errorMsg = null;
		if (StringUtils.hasText(person.getName()) == false)
			errorMsg = "이름을 입력하세요";
		else if (StringUtils.hasText(person.getSex()) == false)
			errorMsg = "성별을 선택하세요";
		else if (StringUtils.hasText(person.getPhone()) == false)
			errorMsg = "전화번호를 입력하세요";
		else if (StringUtils.hasText(person.getEmail()) == false)
			errorMsg = "이메일을 입력하세요";
		else {
			try {
				personMapper.update(person);
				return "redirect:list";
			} catch (Exception e) {
				errorMsg = "저장실패: " + e.getMessage();
			}
		}
		model.addAttribute("errorMsg", errorMsg);
		model.addAttribute("categorys", categoryMapper.findAll());
		return "person/edit";
	}

	@RequestMapping("person/delete")
	public String delete(Model model, int id, RedirectAttributes attributes) {
		try {
			personMapper.delete(id);
			return "redirect:list";
		} catch (Exception e) {
			attributes.addFlashAttribute("errorMsg", "삭제실패: " + e.getMessage());
			return "redirect:edit?id=" + id;
		}
	}
}
