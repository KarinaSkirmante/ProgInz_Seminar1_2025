package lv.venta.repo;

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

}
