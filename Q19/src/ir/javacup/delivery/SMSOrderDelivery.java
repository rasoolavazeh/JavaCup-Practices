package ir.javacup.delivery;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class SMSOrderDelivery implements OrderDelivery{

    private LinkedList<Order> orders = new LinkedList<>();

    @Override
    public Order getCurrentOrder() {
        Order order = orders.getLast();
        orders.removeLast();
        return order;
    }

    @Override
    public void takeNewOrder(Order order) {

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getPhoneNumber() == order.getPhoneNumber() &&
                    String.valueOf(orders.get(i).getWeight()).equals(String.valueOf(order.getWeight()))) {

                orders.remove(orders.get(i));
                orders.add(order);
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
