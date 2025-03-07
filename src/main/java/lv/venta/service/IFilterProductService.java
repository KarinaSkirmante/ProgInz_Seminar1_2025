package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IFilterProductService {
	
	public abstract ArrayList<Product> filterProductsByPriceLessThan(float threashold) throws Exception;

	public abstract ArrayList<Product> filterProductsByContainingText(String searchText) throws Exception;

	public abstract float calculateIncome() throws Exception;
}
