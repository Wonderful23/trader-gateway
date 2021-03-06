package com.example.trader.Dao.Repo.BrokerSideDao.Secured.OrderDao;

import com.example.trader.Dao.Repo.BrokerSideDao.Secured.AbstractOrderDao;
import com.example.trader.Domain.Entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CancelOrderDao")
@Scope("prototype")
public class CancelOrderDao extends AbstractOrderDao {
    private static Logger logger = LoggerFactory.getLogger("CancelOrderDao");

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public String getType() {
        return "cancelOrders";
    }


    public Order modify(String id, Order order) {
        String url = getBroker().getWriteApi() + getType();
        return null;
    }

    public void deleteById(String id) {
        String url = getBroker().getWriteApi() + getType() + "/" + id;
    }

    public Order getById(String  id) {
        String url = getBroker().getReadApi() + getType() + "/" + id;
        return null;
    }
}
