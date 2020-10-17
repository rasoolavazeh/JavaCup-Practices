package ir.javacup.shop;

public abstract class Clothing {

	private String name;
	private Season season;
	private long basePrice;
	private DiscountStrategy discountStrategy = null;
	
	public Clothing(String name, Season season, long basePrice) {
		this.name = name;
		this.season = season;
		this.basePrice = basePrice;
	}

	public long getPrice() {
		// TODO get price by considering discountStrategy
		if (discountStrategy == null)
			return basePrice;
		long price = discountStrategy.priceByDiscount(this);
		return price;
	}
	
	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		// TODO set discountStrategy
		this.discountStrategy = discountStrategy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public long getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(long basePrice) {
		this.basePrice = basePrice;
	}


//	public static void main(String[] args) {
//		Jacket linenCoat = new Jacket("Linen Coat", Season.FALL, 100000);
//		System.out.println("Linen Coat: "  + linenCoat.getPrice());
//
//		linenCoat.setDiscountStrategy(new YaldaDiscountStrategy());
//		System.out.println("Linen Coat with Yalda discount: "  + linenCoat.getPrice());
//
//		linenCoat.setDiscountStrategy(new WinterDiscountStrategy());
//		System.out.println("Linen Coat with Winter discount: "  + linenCoat.getPrice());
//
//		Clothing woolenSocks = new Pants("Woolen Socks", Season.WINTER, 10000);
//		System.out.println("Woolen Socks: "  + woolenSocks.getPrice());
//
//		woolenSocks.setDiscountStrategy(new SummerDiscountStrategy());
//		System.out.println("Woolen Socks with Summer discount: "  + woolenSocks.getPrice());
//
//		woolenSocks.setDiscountStrategy(new WinterDiscountStrategy());
//		System.out.println("Woolen Socks with Winter discount: "  + woolenSocks.getPrice());
//	}
}
