package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.skhu.dto.Book;
import net.skhu.mapper.BookMapper;
import net.skhu.mapper.CategoryMapper;

@Controller
public class BookController {

	@Autowired BookMapper bookMapper;
	@Autowired CategoryMapper categoryMapper;

	@RequestMapping("book/list")
	public String list(Model model) {
		model.addAttribute("books", bookMapper.findAll());
		return "book/list";
	}

	@RequestMapping("book/list1")
	public String list1(Model model, String srchText) {
		if (srchText == null)
			srchText = "";
		model.addAttribute("books", bookMapper.findByTitle(srchText + "%"));
		model.addAttribute("srchText", srchText);
		return "book/list1";
	}

	@RequestMapping("book/list2")
	public String list2(Model model, String srchText) {
		if (srchText == null)
			srchText = "";
		model.addAttribute("books", bookMapper.findByTitle(srchText + "%"));
		model.addAttribute("srchText", srchText);
		return "book/list2";
	}

	@RequestMapping("book/detail")
	public String detail1(Model model, Integer id) {
		if (id == null)
			id = 4;
		model.addAttribute("book", bookMapper.findById(id));
		return "book/detail";
	}

	@RequestMapping("book/detail2")
	public String detail2(Model model, Integer id) {
		if (id == null)
			id = 4;
		model.addAttribute("books", bookMapper.findByCategoryId(id));
		return "book/detail2";
	}
	
	@GetMapping("book/create")
	public String create(Model model) {
		Book book = new Book();
		model.addAttribute("book",book);
		model.addAttribute("categories",categoryMapper.FindAll());
		return "book/create";
	}
	
	@PostMapping("book/create")
	public String create(Model model, Book book) {
		String errorMsg = null;
        if (StringUtils.hasText(book.getTitle()) == false)
            errorMsg = "제목을 입력하세요";
        else if (StringUtils.hasText(book.getAuthor()) == false)
            errorMsg = "저자를 입력하세요";
        else if (book.getPrice() == 0)
            errorMsg = "가격을 입력하세요";
        else {
            try {
            	bookMapper.insert(book);
                return "redirect:list2";
            } catch (Exception e) {
                errorMsg = "저장실패: " + e.getMessage();
            }
        }
		model.addAttribute("errorMsg",errorMsg);
		model.addAttribute("categories",categoryMapper.FindAll());
		return "book/create";
	}
	
    @GetMapping("book/edit")
    public String edit(Model model, int id) {
        Book book = bookMapper.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryMapper.FindAll());
        return "book/create";
    }

    @PostMapping("book/edit")
    public String edit(Model model, Book book) {
		String errorMsg = null;
        if (StringUtils.hasText(book.getTitle()) == false)
            errorMsg = "제목을 입력하세요";
        else if (StringUtils.hasText(book.getAuthor()) == false)
            errorMsg = "저자를 입력하세요";
        else if (book.getPrice() == 0)
            errorMsg = "가격을 입력하세요";
        else {
            try {
            	bookMapper.update(book);
                return "redirect:list2";
            } catch (Exception e) {
                errorMsg = "저장실패: " + e.getMessage();
            }
        }
        model.addAttribute("errorMsg", errorMsg);
        model.addAttribute("categories", categoryMapper.FindAll());
        return "book/create";
    }
	
	@RequestMapping("book/delete")
	public String delete(Model model, int id, RedirectAttributes attributes) {
        try {
            bookMapper.delete(id);
            return "redirect:list2";
        } catch (Exception e) {
            attributes.addFlashAttribute("errorMsg", "삭제실패: " + e.getMessage());
            return "redirect:create?id=" + id;
        }
	}
}
