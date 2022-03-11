package net.skhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Product;

@Controller
public class ProductController {
	@GetMapping("product/edit")
	public String edit(Model model) {
		return "product/edit";
	}

	@PostMapping("product/edit")
	public String edit(Model model, HttpSession session, Product product) {
		String errorMsg = null;
		if (product.getTitle() == null || product.getTitle().length() == 0)
			errorMsg = "제품명을 입력하세요";
		else if (product.getCategory() == 0)
			errorMsg = "카테고리을 선택하세요";
		else if (product.getPrice() == null || product.getPrice() == 0)
			errorMsg = "가격를 입력하세요";
		else if (product.getQuantity() == null || product.getQuantity() == 0)
			errorMsg = "수량을 입력하세요";
		else {
			session.setAttribute("result", product.getPrice()* product.getQuantity());
			session.setAttribute("product", product);
			return "redirect:edit_success";
		}
		model.addAttribute("product", product);
		model.addAttribute("errorMsg", errorMsg);
		return "product/edit";
	}

	@RequestMapping("product/edit_success")
	public String edit_success(Model model) {
		return "product/edit_success";
	}
}
