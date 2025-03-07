package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.service.IFilterProductService;

@Controller
@RequestMapping("/product/filter")
public class ProductFilterController {

	@Autowired
	private IFilterProductService prodService;
	
	
	
	
	@GetMapping("/price/{threshold}")//localhost:8080/product/filter/price/2
	public String getControllerFIlterByPrice
	(@PathVariable(name = "threshold") float threshold, Model model)
	{
		try
		{
			ArrayList<Product> filteredProds =  prodService.filterProductsByPriceLessThan(threshold);
			model.addAttribute("package", filteredProds);
			return "show-all-product-page";//parādīs show-all-product-page.html lapu, kura būs ievietoti izfiltrēti produkti
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīt show-error-page.html lapu, kura būs kļudas ziņojums
		}
	}

	
	
	
}
