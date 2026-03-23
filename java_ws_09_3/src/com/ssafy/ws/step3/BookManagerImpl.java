package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {

	private List<Book> books = new ArrayList<>();
	private static BookManagerImpl instance = new BookManagerImpl();

	private BookManagerImpl() {
	}

	public static BookManagerImpl getInstance() {
		return instance;
	}

	@Override
	public void add(Book book) {
		books.add(book);
	}

	@Override
	public void remove(String isbn) throws ISBNNotFoundException {
		Book b = searchByIsbn(isbn);
		books.remove(b);
	}

	@Override
	public Book[] getList() {
		return books.toArray(new Book[0]);
	}

	@Override
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
		for (Book b : books) {
			if (b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		throw new ISBNNotFoundException(isbn);
	}

	@Override
	public Book[] searchByTitle(String title) {
		List<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (b.getTitle().contains(title)) {
				result.add(b);
			}
		}
		return result.toArray(new Book[0]);
	}

	@Override
	public Magazine[] getMagazines() {
		List<Magazine> result = new ArrayList<>();
		for (Book b : books) {
			if (b instanceof Magazine) {
				result.add((Magazine) b);
			}
		}
		return result.toArray(new Magazine[0]);
	}

	@Override
	public Book[] getBooks() {
		List<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (!(b instanceof Magazine)) {
				result.add(b);
			}
		}
		return result.toArray(new Book[0]);
	}

	@Override
	public int getTotalPrice() {
		int sum = 0;
		for (Book b : books) {
			sum += b.getPrice();
		}
		return sum;
	}

	@Override
	public double getPriceAvg() {
		return books.size() == 0 ? 0 : (double) getTotalPrice() / books.size();
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book b = searchByIsbn(isbn);
		b.setQuantity(b.getQuantity() + quantity);
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {

		Book b = searchByIsbn(isbn);

		if (b.getQuantity() < quantity) {
			throw new QuantityException();
		}

		b.setQuantity(b.getQuantity() - quantity);
	}
}