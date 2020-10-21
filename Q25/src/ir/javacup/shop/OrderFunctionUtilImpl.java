package ir.javacup.shop;

import java.util.function.Function;

public class OrderFunctionUtilImpl implements OrderFunctionUtil{
    @Override
    public Function<Order, Boolean> isBigOrder() {
        Function<Order, Boolean> ob = order -> order.getProducts()
                .stream()
                .mapToLong(product -> product.getPrice()).sum() >= 10000000 ? true : false;
        return ob;
    }

    @Override
    public Function<Order, Boolean> hasMultipleProducts() {
        Function<Order, Boolean> ob = order -> order.getProducts().size() > 1 ? true : false;
        return ob;
    }

    @Override
    public Function<Order, Boolean> hasUnavailableProduct() {
        Function<Order, Boolean> ob = order -> order.getProducts()
                .stream()
                .anyMatch(product -> product.getState() == ProductState.UNAVAILABLE) ? true : false;

        return ob;
    }

    @Override
    public Function<Order, Boolean> isReadyToDeliver() {
        Function<Order, Boolean> ob = order -> order.getProducts()
                .stream()
                .allMatch(product -> product.getState() == ProductState.AVAILABLE) && order.getState() == OrderState.READY_TO_SEND ? true : false;
        return ob;
    }

    @Override
    public Function<Order, Boolean> hasPerishableProduct() {
        Function<Order, Boolean> ob = order -> order.getProducts()
                .stream()
                .anyMatch(product -> product.getType() == ProductType.PERISHABLE) ? true : false;
        return ob;
    }

    @Override
    public Function<Order, Boolean> hasExpensiveBreakableProduct() {
        Function<Order, Boolean> ob = order -> order.getProducts()
                .stream()
                .anyMatch(product -> product.getType() == ProductType.BREAKABLE && product.getPrice() >= 5000000) ? true : false;
        return ob;
    }
}
