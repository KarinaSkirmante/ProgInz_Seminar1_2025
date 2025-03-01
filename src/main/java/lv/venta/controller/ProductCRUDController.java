package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.Product;
import lv.venta.service.ICRUDProductService;

@Controller
@RequestMapping("/product/crud") //visi get un post sāksies ar /product/crud
public class ProductCRUDController {
	
	@Autowired
	private ICRUDProductService prodService;
	
	
	@GetMapping("/all")//localhost:8080/product/crud/all
	public String getControllerAllProducts(Model model) {
		try
		{
			ArrayList<Product> allProducts = prodService.retrieveAll();//dabūs visus produktus no DB
			model.addAttribute("package", allProducts);
			return "show-all-product-page";//parādīs show-all-product-page.html ar jau produktiem no DB
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīs show-error-page.html ar izmesto kļūdu
		}
	
	}
	
	
	
	@GetMapping("/one")//localhost:8080/product/crud/one?id=2
	public String getControllerGetOneProductById(@RequestParam(name = "id") int id, Model model)
	{
		try
		{
			Product oneProduct = prodService.retreiveById(id);
			model.addAttribute("package", oneProduct);
			return "show-one-product-page";//parādīs show-one-product-page.html lapu ar jau konkrēto produktu
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīs show-error-page.html ar izmesto kļūdu
		}
		}
	
	
	//localhost:8080/product/crud/all/2
	
	
	
	
	
	
	

}
