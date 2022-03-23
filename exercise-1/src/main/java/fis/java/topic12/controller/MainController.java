package fis.java.topic12.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fis.java.topic12.model.Product;
import fis.java.topic12.service.ProductService;

@Controller
public class MainController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	ProductService productService;

	@GetMapping("/index")
	public String getIndex(Model model) {
		List<Product> list = productService.findAll();
		LOGGER.info("Get " + list.size() + " products");
		model.addAttribute("products", list);
		return "home";
	}
}
