package com.example.trader.Core.Processor.Strategy;

import com.example.trader.Domain.Entity.Order;
import com.example.trader.Core.Processor.Processor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TwapProcessor extends Processor {
    @Override
    public List<Order> process(Order order){
        return null;
    }
}