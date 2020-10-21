package ir.javacup.shop;

import java.util.function.Function;

public interface OrderFunctionUtil {
	
	Function<Order, Boolean> isBigOrder();
	
	Function<Order, Boolean> hasMultipleProducts();
	
	Function<Order, Boolean> hasUnavailableProduct();
	
	Function<Order, Boolean> isReadyToDeliver();
	
	Function<Order, Boolean> hasPerishableProduct();
	
	Function<Order, Boolean> hasExpensiveBreakableProduct();
	
}
