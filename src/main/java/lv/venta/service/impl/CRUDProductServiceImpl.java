package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.ProductRepo;
import lv.venta.service.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService{

	@Autowired
	private ProductRepo prodRepo;
	
	
	@Override
	public void create(String title, String description,
			float price, int quantity) throws Exception {
		if(title == null || description == null || price < 0 || quantity < 0) {
			throw new Exception("Ievades parametri nav pareizi");
		}
		//tāds produkrs jau eksistē
		if(prodRepo.existsByTitleAndDescriptionAndPrice(title, description, price))
		{
			Product existingProduct = 
					prodRepo.findByTitleAndDescriptionAndPrice(title, description, price);
			
			int newQuantity = existingProduct.getQuantity() + quantity;//aprēķinām jauno daudzumu
			existingProduct.setQuantity(newQuantity);//jauno daudzumu saglabāj javas objektam
			prodRepo.save(existingProduct);//izsaucās update vaicājums, jo produkts jau eksistē
		}
		else
		{
			Product newProduct = new Product(title, description, price, quantity);
			prodRepo.save(newProduct);
		}
		
		
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(prodRepo.count()==0)
		{
			throw new Exception("Tabulā nav neviena ieraksta");
		}
		
		ArrayList<Product> allProducts = (ArrayList<Product>) prodRepo.findAll();
		return allProducts;
	}

	@Override
	public Product retreiveById(int id) throws Exception {
		if(id < 0)
		{
			throw new Exception("Id nevar būt negatīvs");
		}
		
		if(!prodRepo.existsById(id))
		{
			throw new Exception("Produkts ar tādu id neeksistē");
		}
		
		Product retrievedProduct = prodRepo.findById(id).get();
		return retrievedProduct;
		
	}

	@Override
	public void updateById(int id, float price, int quantity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		if(id < 0)
		{
			throw new Exception("Id nevar būt negatīvs");
		}
		
		if(!prodRepo.existsById(id))
		{
			throw new Exception("Produkts ar tādu id neeksistē");
		}
		
		//īsais pieraksts
		prodRepo.deleteById(id);
		//garais pieraksts
		//Product retrievedProduct = prodRepo.findById(id).get();
		//prodRepo.delete(retrievedProduct);
		
	}

}
