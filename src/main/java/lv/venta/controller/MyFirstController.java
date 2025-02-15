package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;
//kontrolieru klase
@Controller
public class MyFirstController {
	
	@GetMapping("/simple") //localhost:8080/simple
	public String getControllerSimple()
	{
		System.out.println("Ir izsaukusies simple funkcija");
		return "simple-page";//parādīs  simple-page.html
	}
	
	
	
	
	@GetMapping("/getdata") //localhost:8080/getdata
	public String getControllerGetData(Model model) {
		System.out.println("Ir izsaukusies get data funkcija");
		
		Random rand = new Random();
		String data = "Karina: " + rand.nextInt(0, 100);
		
		model.addAttribute("package", data);
		return "data-page";//parādīs data-page.html
	}
	//TODO izveidot jaunu kontroliera funkciju un kurā
	//1. izveidot testa produkta objektu
	//2. padot to caur paciņu html lapa
	//izveidot atbilstosu html lapu
	
	@GetMapping("/getproduct") //localhost:8080/getproduct
	public String getControllerGetProduct(Model model) {
		
		Product testProduct = new Product("Tomāts", "Garšīgs", 0.99f, 5);
		
		model.addAttribute("package", testProduct);	
		return "show-one-product-page"; //parādīs show-one-product-page.html
		
		
	}
	
	
	

}
