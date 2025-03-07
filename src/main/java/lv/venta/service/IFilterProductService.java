package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IFilterProductService {
	
	public abstract ArrayList<Product> filterProductsByPriceLessThan(float threshold) throws Exception;

	public abstract ArrayList<Product> filterProductsByQuantityLargerThan(int threshold) throws Exception;
	
	public abstract ArrayList<Product> filterProductsByContainingText(String searchText) throws Exception;

	public abstract float calculateIncome() throws Exception;
}
