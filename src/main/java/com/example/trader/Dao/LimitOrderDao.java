package com.example.trader.Dao;

import com.alibaba.fastjson.JSON;
import com.example.trader.Domain.Entity.Order;
import com.example.trader.Domain.Wrapper.ResponseWrapper;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("LimitOrderDao")
@Scope("prototype")
public class LimitOrderDao extends DynamicDao<String, Order> {

    private RestTemplate restTemplate = new RestTemplate();

    public Order create(Order  order) {
        String url = getSource() + "/LimitOrder";
        ResponseEntity<ResponseWrapper> responseEntity = restTemplate.postForEntity(url, order, ResponseWrapper.class);

        ResponseWrapper rw = responseEntity.getBody();  //响应体转换为Book类型
        int statusCodeValue = responseEntity.getStatusCodeValue();  //响应状态码
        HttpHeaders headers = responseEntity.getHeaders();  //响应头信息

        System.out.println(JSON.toJSONString(rw));
        return null;
    }

    public Order modify(String id, Order order) {
        String url = getSource() + "/LimitOrder";
        return null;
    }

    public void deleteById(String id) {
        String url = getSource() + "/LimitOrder/" + id;
    }

    public Order getById(String  id) {
        String url = getSource() + "/LimitOrder/" + id;
        return null;
    }
}