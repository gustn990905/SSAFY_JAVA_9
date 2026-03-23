package com.ssafy.hw.step4;

import java.util.List;

public interface IProductManager {
	boolean addProduct(Product product);

	boolean updateProduct(Product product);

	boolean removeProduct(String pCode);

	int sell(String pCode, int cnt) throws ProductCodeNotFoundException, QuantityException;

	Product[] getProductList();

	Product searchByCode(String pCode) throws ProductCodeNotFoundException;

	Product[] searchByName(String name) throws NameNotFoundException;

	boolean addReview(Review review);

	boolean removeReview(Review review);

	List<Review> getProductReview(String pCode) throws ReviewNotFoundException;

	long getTotalPrice();

	Product[] getProducts();

	Refrigerator[] getRefrigerators();

	Refrigerator[] getRefrigeratorsFreezer(boolean freezer);
}