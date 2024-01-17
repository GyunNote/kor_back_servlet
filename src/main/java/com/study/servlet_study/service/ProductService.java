package com.study.servlet_study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.study.servlet_study.entity.Product;
import com.study.servlet_study.repository.ProductRepository;

public class ProductService {
	
	
	private static ProductService instance;
	private ProductRepository productRepository;
	private ProductService() {
		productRepository = ProductRepository.getInstance();
		
	}
	
	public static ProductService getInstance(){
		if(instance == null) {
			instance = new ProductService();
		}
		return instance;
		
	}
	public int addProduct(Product product) {
		return productRepository.saveProduct(product);
	}
	
	public Product getProduct(String productName) {
		return productRepository.findProductBy(productName);
	}
	

}
