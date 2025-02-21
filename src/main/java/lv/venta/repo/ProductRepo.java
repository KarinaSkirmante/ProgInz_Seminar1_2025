package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {

}
