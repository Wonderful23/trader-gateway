package com.example.trader.Core.Processor.Strategy;

import com.example.trader.Domain.Entity.Order;
import com.example.trader.Core.Processor.Processor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class NoneProcessor implements Processor {
    @Override
    public List<Order> process(Order order) {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders;
    }
}
