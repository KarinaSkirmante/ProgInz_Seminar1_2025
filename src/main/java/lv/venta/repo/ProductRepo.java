package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {
	//sī funkcija pārbauda, vai eksistē tāds produkts
	public abstract boolean existsByTitleAndDescriptionAndPrice(
			String title, String description, float price);
	
	//atgriež eksistējošo produktu
	//apakšā izveidos: 
	//select * from product where title= 'Gurķis' and description = 'Zaļš' and price = 1.99;
	public abstract Product findByTitleAndDescriptionAndPrice(
			String title, String description, float price);

	//šeit apakšā izveidosies vaicājums
	//select * from product where price < 2 (ja threshold ir 2)
	public abstract ArrayList<Product> findByPriceLessThan(float threshold);
	
	//šeit apakšā izveidosies vaicājums
	//select * from product where quantity > 6;(ja threshold ir 6)
	public abstract ArrayList<Product> findByQuantityGreaterThan(int threshold);

}
