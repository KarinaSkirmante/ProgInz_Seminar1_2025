package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
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
	//šeit apakšā izveidosies vaicājums
	//select * from product where description like '%abc%' OR title like '%abc%'; (ja searchtext un searchText2 ir abc)
	public abstract ArrayList<Product> findByTitleContainingOrDescriptionContaining(String searchText,
			String searchText2);

	//var paši veidot vaicajumus, bet tad jāizmato Quary anotācija
	@Query(nativeQuery = true, value = "select sum(price * quantity) from product;")
	public abstract float calculateSumFromProduct();

}
