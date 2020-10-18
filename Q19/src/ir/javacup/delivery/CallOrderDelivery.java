package ir.javacup.delivery;

import java.util.*;

public class CallOrderDelivery implements OrderDelivery{

    LinkedList<Order> orders = new LinkedList<>();

    @Override
    public Order getCurrentOrder() {
        Order order = orders.getFirst();
        orders.removeFirst();
        return order;
    }

    @Override
    public void takeNewOrder(Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getPhoneNumber() == order.getPhoneNumber() &&
                    String.valueOf(orders.get(i).getWeight()).equals(String.valueOf(order.getWeight()))) {

                return;
            }
        }

        orders.add(order);
    }

    @Override
    public Collection<Order> getOrders() {
        return orders;
    }
}
