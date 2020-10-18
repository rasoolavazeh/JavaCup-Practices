package ir.javacup.delivery;

import java.util.Collection;

public interface OrderDelivery {
	
	Order getCurrentOrder();
	
	void takeNewOrder(Order order);
	
	Collection<Order> getOrders();

}
