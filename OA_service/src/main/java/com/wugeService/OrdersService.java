package com.wugeService;

import com.wugeDomain.Orders;
import com.wugeDomain.UserInfo;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(int page,int pageSize);
    Orders findById(int id);

}
