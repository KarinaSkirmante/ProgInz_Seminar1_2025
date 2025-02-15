package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	//TODO izveidot model pakotni
	//TODO izveidot model pakotnē Product klasi, 
	//kas ietver int id, float price, String title, String description, 
	//int quantiy
	

}
