package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Product")
@Entity
public class Product {
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Title")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z ]{3,30}")
	private String title;
	
	
	@NotNull
	@Pattern(regexp = "[A-Za-b ,]{5,100}")
	//@Size(min = 5, max = 100) <- ja nenorādam regex maska izmeru, tad to var norādīt šādi
	@Column(name = "Description")
	private String description;
	
	@Min(0)
	@Max(10000)
	@Column(name = "Price")
	private float price;
	
	@Min(0)
	@Max(1000)
	@Column(name = "Quantity")
	private int quantity;
	


	
	public Product(String inputTitle, String inputDescription, float inputPrice, int inputQuantity)
	{
		setTitle(inputTitle);
		setDescription(inputDescription);
		setPrice(inputPrice);
		setQuantity(inputQuantity);
	}
}
