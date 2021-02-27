package com.wugeService.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wugeDao.OrdersMapper;
import com.wugeDomain.Orders;
import com.wugeService.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private  OrdersMapper ordersMapper;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Orders findById(int id) {
        return ordersMapper.findById(id);
    }

    @Override
    public List<Orders> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);


        return ordersMapper.findAll();
    }
}
