package com.example.trader.Controller;

import com.alibaba.fastjson.JSON;
import com.example.trader.Core.Processor.ProcessorFactory;
import com.example.trader.Core.Sender.SenderFactory;
import com.example.trader.Domain.Factory.ResponseWrapperFactory;
import com.example.trader.Domain.Entity.Order;
import com.example.trader.Domain.Wrapper.ResponseWrapper;
import com.example.trader.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public ResponseWrapper createWithStrategy(
            @RequestBody Order order,
            @RequestParam(defaultValue = ProcessorFactory.NONE) String processStrategy,
            @RequestParam(defaultValue = SenderFactory.INSTANT) String sendStrategy,
            @RequestParam Integer brokerId) {
        System.out.println(JSON.toJSONString(order));
        List<Order> orders = orderService.createWithStrategy(order, processStrategy, sendStrategy, brokerId);
        return ResponseWrapperFactory.create(ResponseWrapper.SUCCESS, orders);
        /*
        try{
            List<Order> orders = orderService.createWithStrategy(order, processStrategy, sendStrategy, brokerId);
            return ResponseWrapperFactory.create(ResponseWrapper.SUCCESS, orders);
        }
        catch(Exception e){
            return ResponseWrapperFactory.create(ResponseWrapper.ERROR, e.getMessage());
        }*/

    }

    @PostMapping("/MarketOrder")
    public ResponseWrapper createMarketOrder(
            @RequestBody Order marketOrder,
            @RequestParam Integer brokerId){
        try{
            Order order = orderService.create(marketOrder, brokerId);
            return ResponseWrapperFactory.create(ResponseWrapper.SUCCESS, order);
        }
        catch(Exception e){
            return ResponseWrapperFactory.create(ResponseWrapper.ERROR, e.getMessage());
        }
    }

    @PostMapping("/LimitOrder")
    public ResponseWrapper createLimitOrder(
            @RequestBody Order limitOrder,
            @RequestParam Integer brokerId){
        try{
            Order order = orderService.create(limitOrder, brokerId);
            return ResponseWrapperFactory.create(ResponseWrapper.SUCCESS, order);
        }
        catch(Exception e){
            return ResponseWrapperFactory.create(ResponseWrapper.ERROR, e.getMessage());
        }
    }

    @PostMapping("/StopOrder")
    public ResponseWrapper createStopOrder(
            @RequestBody Order stopOrder,
            @RequestParam Integer brokerId){
        try{
            Order order = orderService.create(stopOrder, brokerId);
            return ResponseWrapperFactory.create(ResponseWrapper.SUCCESS, order);
        }
        catch(Exception e){
            return ResponseWrapperFactory.create(ResponseWrapper.ERROR, e.getMessage());
        }
    }

    @PostMapping("/CancelOrder")
    public ResponseWrapper createCancelOrder(
            @RequestBody Order cancelOrder,
            @RequestParam Integer brokerId){
        try{
            Order order = orderService.create(cancelOrder, brokerId);
            return ResponseWrapperFactory.create(ResponseWrapper.SUCCESS, order);
        }
        catch(Exception e){
            return ResponseWrapperFactory.create(ResponseWrapper.ERROR, e.getMessage());
        }
    }
}