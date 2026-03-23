package com.ssafy.hw.step4;

import java.util.*;

public class ProductManagerImpl implements IProductManager {

	private List<Product> products = new ArrayList<>();
	private Map<String, List<Review>> reviews = new HashMap<>();

	private static IProductManager instance = new ProductManagerImpl();

	private ProductManagerImpl() {
	}

	public static IProductManager getInstance() {
		return instance;
	}

	@Override
	public boolean addProduct(Product product) {
		return products.add(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			Product p = searchByCode(product.getpCode());
			p.setQuantity(product.getQuantity());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeProduct(String pCode) {
		try {
			Product p = searchByCode(pCode);
			products.remove(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int sell(String pCode, int cnt) throws ProductCodeNotFoundException, QuantityException {

		Product p = searchByCode(pCode);

		if (p.getQuantity() < cnt)
			throw new QuantityException();

		p.setQuantity(p.getQuantity() - cnt);
		return p.getQuantity();
	}

	@Override
	public Product[] getProductList() {
		return products.toArray(new Product[0]);
	}

	@Override
	public Product searchByCode(String pCode) throws ProductCodeNotFoundException {
		for (Product p : products) {
			if (p.getpCode().equals(pCode))
				return p;
		}
		throw new ProductCodeNotFoundException(pCode);
	}

	@Override
	public Product[] searchByName(String name) throws NameNotFoundException {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p.getpName().contains(name))
				result.add(p);
		}
		if (result.isEmpty())
			throw new NameNotFoundException(name);
		return result.toArray(new Product[0]);
	}

	@Override
	public boolean addReview(Review review) {
		reviews.putIfAbsent(review.getpCode(), new ArrayList<>());
		return reviews.get(review.getpCode()).add(review);
	}

	@Override
	public boolean removeReview(Review review) {
		List<Review> list = reviews.get(review.getpCode());
		if (list != null)
			return list.remove(review);
		return false;
	}

	@Override
	public List<Review> getProductReview(String pCode) throws ReviewNotFoundException {
		List<Review> list = reviews.get(pCode);
		if (list == null || list.isEmpty())
			throw new ReviewNotFoundException(pCode);
		return list;
	}

	@Override
	public long getTotalPrice() {
		long sum = 0;
		for (Product p : products) {
			sum += p.getPrice();
		}
		return sum;
	}

	@Override
	public Product[] getProducts() {
		return getProductList();
	}

	@Override
	public Refrigerator[] getRefrigerators() {
		List<Refrigerator> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof Refrigerator)
				result.add((Refrigerator) p);
		}
		return result.toArray(new Refrigerator[0]);
	}

	@Override
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		List<Refrigerator> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof Refrigerator) {
				Refrigerator r = (Refrigerator) p;
				if (r.isFreezer() == freezer)
					result.add(r);
			}
		}
		return result.toArray(new Refrigerator[0]);
	}
}