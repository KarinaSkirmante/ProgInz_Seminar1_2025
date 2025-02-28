package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface ICRUDProduct {
	//visas funkciajs vienmēr būs public un abstract
	//CRUD - create, retrieve, update, delete
	
	//C - create
	public abstract void create(String title, String description,float price, int quantity);

	//R - retrieve all
	public abstract ArrayList<Product> retrieveAll() throws Exception;
		
	//R - retrieve by id
	public abstract Product retreiveById(int id) throws Exception;
	
	//U - update
	public abstract void updateById(int id, float price, int quantity) throws Exception;
	
	//D - delete
	public abstract void deletyById(int id) throws Exception;
	
}
