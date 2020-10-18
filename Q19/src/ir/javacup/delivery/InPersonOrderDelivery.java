package ir.javacup.delivery;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class InPersonOrderDelivery implements OrderDelivery{

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
            if (orders.get(i).getName().equals(order.getName())) {
                return;
            }
        }

        orders.add(order);
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                char secondCharO1 = o1.getName().charAt(1);
                char secondCharO2 = o2.getName().charAt(1);
                return secondCharO1 < secondCharO2 ? -1 :
                        (secondCharO1 == secondCharO2 ? 0 : 1);
            }
        };
        Collections.sort(orders, comparator);
    }

    @Override
    public Collection<Order> getOrders() {
        return orders;
    }
}
