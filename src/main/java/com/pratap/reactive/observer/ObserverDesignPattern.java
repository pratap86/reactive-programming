package com.pratap.reactive.observer;
/**
 * Driver Class
 * @author Pratap Narayan
 *
 */
public class ObserverDesignPattern {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Book book = new Book("Ramayana", "Valmiki", "Epic", 1330.98, "SoldOut");
		
		EndUser user1 = new EndUser("Pratap Narayan", book);
		EndUser user2 = new EndUser("Deepika Nishad", book);
		EndUser user3 = new EndUser("Sanjay Nishad", book);
		
		System.out.println(book.getInStock());
		book.setInStock("In Stock");
	}

}
