package ir.javacup.shop;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private String code;
	private long price;
	private String buyyer;
	private OrderState state;
	private List<Product> products = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Order code(String code) {
		this.code = code;
		return this;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public Order price(long price) {
		this.price = price;
		return this;
	}

	public String getBuyyer() {
		return buyyer;
	}

	public void setBuyyer(String buyyer) {
		this.buyyer = buyyer;
	}
	
	public Order buyyer(String buyyer) {
		this.buyyer = buyyer;
		return this;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}
	
	public Order state(OrderState state) {
		this.state = state;
		return this;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Order product(Product product) {
		if (products == null) {
			products = new ArrayList<>();
		}
		products.add(product);
		return this;
	}

}
