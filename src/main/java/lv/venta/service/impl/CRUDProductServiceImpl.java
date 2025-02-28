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
	public void create(String title, String description, float price, int quantity) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
