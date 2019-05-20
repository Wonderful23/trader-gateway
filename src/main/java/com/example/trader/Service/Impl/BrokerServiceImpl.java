package com.example.trader.Service.Impl;

import com.example.trader.Core.BrokerSocket.BrokerSocketContainer;
import com.example.trader.Dao.BrokerDao;
import com.example.trader.Domain.Entity.Broker;
import com.example.trader.Service.BrokerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BrokerServiceImpl implements BrokerService {
    private static ConcurrentHashMap<Integer, BrokerSocketContainer> brokerSocketContainers = new ConcurrentHashMap<>();

    @Autowired
    private BrokerDao brokerDao;
    @Override
    public Broker addBroker(Broker broker){
        Broker b = brokerDao.saveAndFlush(broker);
        BrokerSocketContainer brokerSocket = new BrokerSocketContainer(b);
        brokerSocketContainers.put(b.getId(), brokerSocket);
        return b;
    }

    @Override
    public boolean deleteBrokerById(Integer id){
        brokerSocketContainers.get(id).close();
        brokerSocketContainers.remove(id);
        brokerDao.deleteById(id);
        return true;
    }

    @Override
    public List<Broker> getBroker(){
        return brokerDao.findAll();
    }

    @Override
    public Broker getBrokerById(Integer id) {
        BrokerSocketContainer bsc = brokerSocketContainers.get(id);
        if (bsc == null) {
            return brokerDao.findById(id).get();
        }
        else
            return bsc.getBroker();
    }
}