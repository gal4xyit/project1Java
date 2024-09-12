package org.example;

import java.util.ArrayList;
import java.util.List;

public class Story {
    private int orderId;
    private List<Order> orders;

    public Story() {
        orderId = 0;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void clearStory() {
        orders.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Історія замовлень:\n");
        for (Order order : orders) {
            orderId++;
            sb.append("Замовлення №").append(orderId).append("\n");
            sb.append(order.toString()).append("\n");
        }
        orderId=0;
        return sb.toString();
    }
}
