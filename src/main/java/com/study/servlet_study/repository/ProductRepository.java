package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Product;
import com.study.servlet_study.servlet.ProductServlet;

public class ProductRepository {
	
	private static ProductRepository instance;
	private List<Product> productList;
	
	private ProductRepository() {
		productList = new ArrayList<>();
	}
	
	public static ProductRepository getInstance(){
		if(instance == null) {
			instance = new ProductRepository();
		}
		return instance;
	}
	
	
	public int saveProduct(Product product) {
//	
//		for(Product product1 : productList) {
//			if(product1.getProductName().equals(product.getProductName())) {
//				return 0;
//			} 
//		}
				productList.add(product);
				return 1;
	}
		
	public Product findProductBy(String productName) {
		Product findProduct = null;
		
		for(Product product : productList) {
			if(product.getProductName().equals(productName)) {
				findProduct = product;
				break;
			}
		}
		return findProduct;
			
	}
	
}








