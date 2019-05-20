package com.example.trader.Core.Sender;

import com.example.trader.Domain.Entity.Broker;
import com.example.trader.Domain.Entity.Order;
import com.example.trader.Domain.Wrapper.ResponseWrapper;

import java.util.List;

public abstract class Sender {
    public abstract ResponseWrapper send(List<Broker> brokers, List<Order> orders);
}