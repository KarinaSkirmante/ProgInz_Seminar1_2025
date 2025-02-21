package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.repo.ProductRepo;

@SpringBootApplication
public class Seminar1Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testModelLayer(ProductRepo prodRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product pr1 = new Product("Gurķis", "Zaļš", 1.99f, 7);
				Product pr2 = new Product("Arbūzs", "Salds", 5.99f, 2);
				Product pr3 = new Product("Burkāns", "Veselīgs", 0.45f, 5);
				prodRepo.save(pr1);
				prodRepo.save(pr2);
				prodRepo.save(pr3);
				
				//TODO
				//izņemt datus
				//rediget datus
				//dabut visus datus no tabulas
				//dabut tikai vienu ierakstu,ja ir zinams id
				
				
				
			}
		};
	}

}
