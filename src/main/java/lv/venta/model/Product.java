package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	@Setter(value = AccessLevel.NONE)
	private int id;
	
	private String title;
	private String description;
	private float price;
	private int quantity;
	
	@Setter(value = AccessLevel.NONE)
	@Getter(value = AccessLevel.NONE)
	private static int counter = 0;
	
	public void setId() {
		id = counter;
		counter++;
	}
	
	public Product(String inputTitle, String inputDescription, float inputPrice, int inputQuantity)
	{
		setId();
		setTitle(inputTitle);
		setDescription(inputDescription);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
	}
}
