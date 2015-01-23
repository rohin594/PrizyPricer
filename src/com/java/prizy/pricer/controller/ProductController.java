package com.java.prizy.pricer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.prizy.pricer.business.ProductBusiness;
import com.java.prizy.pricer.domain.Product;

@Controller
@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
public class ProductController {

	@Autowired
	private ProductBusiness productBusiness;

	public void setProductBusiness(ProductBusiness productBusiness) {
		this.productBusiness = productBusiness;
	}

	@RequestMapping(value = "/addProduct")
	public ModelAndView addProduct() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addProductDetails");
		Product product = new Product();
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping(value = "/saveProduct")
	public String saveProduct(Model model, Product product) {
		boolean result = productBusiness.saveProduct(product);
		if (result) {
			model.addAttribute("message", "The Product saved successfully.");
			return "index";
		} else {
			model.addAttribute("message", "No product Exists with barcode - "
					+ product.getBarCode());
			return "addProductDetails";
		}
	}

	@RequestMapping(value = "/listProducts")
	public String getAllProducts(Model model,
			@RequestParam(value = "start") Integer start,
			@RequestParam(value = "end") Integer end) {
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("products", productBusiness.getProductsList());
		return "allProducts";
	}

	@RequestMapping(value = "/productDetails/{barCode}")
	public String getProductDetails(@PathVariable String barCode, Model model) {
		model.addAttribute("product",
				productBusiness.getProductDetails(barCode));
		return "productDetails";
	}

	@RequestMapping(value = "/index")
	public String indexPage() {
		return "index";
	}
}
