package cn.itcast.domain;

public class CartItem {

	private Book book;
	private int quantity;
	private double price;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		//根据书和数量算出价格
		this.price = this.book.getPrice()*quantity;
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
}
