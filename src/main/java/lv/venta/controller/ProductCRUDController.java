package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.model.Product;
import lv.venta.service.ICRUDProductService;

@Controller
@RequestMapping("/product/crud") // visi get un post sāksies ar /product/crud
public class ProductCRUDController {

	@Autowired
	private ICRUDProductService prodService;

	@GetMapping("/all") // localhost:8080/product/crud/all
	public String getControllerAllProducts(Model model) {
		try {
			ArrayList<Product> allProducts = prodService.retrieveAll();// dabūs visus produktus no DB
			model.addAttribute("package", allProducts);
			return "show-all-product-page";// parādīs show-all-product-page.html ar jau produktiem no DB
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
		}

	}

	@GetMapping("/one") // localhost:8080/product/crud/one?id=2
	public String getControllerGetOneProductById(@RequestParam(name = "id") int id, Model model) {
		try {
			Product oneProduct = prodService.retreiveById(id);
			model.addAttribute("package", oneProduct);
			return "show-one-product-page";// parādīs show-one-product-page.html lapu ar jau konkrēto produktu
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
		}
	}

	// localhost:8080/product/crud/all/2
	@GetMapping("/all/{id}")
	public String getControllerGetOnProductById2(@PathVariable(name = "id") int id, Model model) {
		try {
			Product oneProduct = prodService.retreiveById(id);
			model.addAttribute("package", oneProduct);
			return "show-one-product-page";// parādīs show-one-product-page.html lapu ar jau konkrēto produktu
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
		}
	}

	@GetMapping("/create") // localhost:8080/product/crud/create
	public String getControllerCreateProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);// tiks iedots līdzi tukšs produkts, ko pēc tam aizpildīs frontendā
		return "create-product";// parādīs create-product.html lapu
	}

	@PostMapping("/create")
	public String postControllerCreateProduct(@Valid Product product, BindingResult result, Model model) {// iegūsim
		// lapas
		if (product == null) {
			model.addAttribute("package", "Nav iegūts aizpildītais produkts");
			return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
		}

		if (result.hasErrors()) {
			return "create-product";
		} else {

			try {
				prodService.create(product.getTitle(), product.getDescription(), product.getPrice(),
						product.getQuantity());
				return "redirect:/product/crud/all";// pārleks uz /product/crud/all get kontrolieri

			} catch (Exception e) {
				model.addAttribute("package", e.getMessage());
				return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
			}
		}

	}

	@GetMapping("/update/{id}") // localhost:8080/product/crud/update/2
	public String getControllerUpdateProductById(@PathVariable(name = "id") int id, Model model) {
		try {
			Product foundproduct = prodService.retreiveById(id);
			model.addAttribute("product", foundproduct);// tiks padots līdzi jau atrastais produkts
			return "update-product";// parādit update-product.html lapu
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
		}
	}

	@PostMapping("/update/{id}")
	public String postControllerUpdateProductById(@Valid Product product, BindingResult result,
			@PathVariable(name = "id") int id, Model model) {// iegūs

		if (product == null) {
			model.addAttribute("package", "Nav iegūts aizpildītais produkts");
			return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
		}

		if (result.hasErrors()) {
			try
			{
				//TODO salabot, lai title un desription pēc submit pogas arī paliek
				Product product2 = prodService.retreiveById(id);
				product.setTitle(product2.getTitle());
				product.setDescription(product2.getDescription());
				model.addAttribute("product", product);
				return "update-product";
			}
			catch (Exception e) {
				model.addAttribute("package", e.getMessage());
				return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
			}
		}

		else {

			try {
				prodService.updateById(id, product.getPrice(), product.getQuantity());
				return "redirect:/product/crud/all";
			} catch (Exception e) {
				model.addAttribute("package", e.getMessage());
				return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
			}
		}
	}

	@GetMapping("/delete/{id}") // locahost:8080/product/crud/delete/2
	public String getControllerDeleteById(@PathVariable(name = "id") int id, Model model) {
		try {
			prodService.deleteById(id);
			model.addAttribute("package", prodService.retrieveAll());
			return "show-all-product-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";// parādīs show-error-page.html ar izmesto kļūdu
		}

	}

}
