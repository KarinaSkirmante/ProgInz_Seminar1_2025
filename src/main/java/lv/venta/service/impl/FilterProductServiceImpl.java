package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.ProductRepo;
import lv.venta.service.IFilterProductService;

@Service
public class FilterProductServiceImpl implements IFilterProductService {

	@Autowired
	private ProductRepo prodRepo;
	
	@Override
	public ArrayList<Product> filterProductsByPriceLessThan(float threshold) throws Exception {
		if(threshold < 0 || threshold > 10000 )
		{
			throw new Exception("Nepareizi padots cenu slieksnis");
		}
		
		ArrayList<Product> filteredProducts = prodRepo.findByPriceLessThan(threshold);
		
		if(filteredProducts.isEmpty())
		{
			throw new Exception("Veikalā nav neviens produkts, kura cena būtu mazāka par " + threshold);
		}
		
		return filteredProducts;
	}

	@Override
	public ArrayList<Product> filterProductsByContainingText(String searchText) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateIncome() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Product> filterProductsByQuantityLargerThan(int threshold) throws Exception {
		if(threshold < 0 || threshold > 1000 )
		{
			throw new Exception("Nepareizi padots daudzuma slieksnis");
		}
		
		ArrayList<Product> filteredProducts = prodRepo.findByQuantityGreaterThan(threshold);
		
		if(filteredProducts.isEmpty())
		{
			throw new Exception("Veikalā nav neviens produkts, kura daudzums būtu lielāks par " + threshold);
		}
		
		return filteredProducts;
	}

}
