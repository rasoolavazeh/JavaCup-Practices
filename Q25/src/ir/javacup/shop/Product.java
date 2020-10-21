package ir.javacup.shop;

public class Product {

	private String code;
	private String title;
	private long price;
	private ProductState state;
	private ProductType type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Product code(String code) {
		this.code = code;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Product title(String title) {
		this.title = title;
		return this;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public Product price(long price) {
		this.price = price;
		return this;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}
	
	public Product state(ProductState state) {
		this.state = state;
		return this;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}
	
	public Product type(ProductType type) {
		this.type = type;
		return this;
	}


}
