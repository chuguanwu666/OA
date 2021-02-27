package com.wugeDao;

import com.wugeDomain.Member;
import com.wugeDomain.Orders;
import com.wugeDomain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Scanner;

public interface OrdersMapper {
    @Select("select *from orders")
    @Results(
            {
                    @Result(id = true,property ="id",column = "id"),
                    @Result(property ="orderNum",column = "orderNum"),
                    @Result(property ="orderTime",column = "orderTime"),
                    @Result(property ="orderStatus",column = "orderStatus"),
                    @Result(property ="peopleCount",column = "peopleCount"),
                    @Result(property ="payType",column = "payType"),
                    @Result(property ="orderDesc",column = "orderDesc"),
                    @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.wugeDao.ProductMapper.getById"))

            }
    )
    List<Orders> findAll();
    @Select("select *from orders where id=#{id}")
    @Results(
            {
                    @Result(id = true,property ="id",column = "id"),
                    @Result(property ="orderNum",column = "orderNum"),
                    @Result(property ="orderTime",column = "orderTime"),
                    @Result(property ="orderStatus",column = "orderStatus"),
                    @Result(property ="peopleCount",column = "peopleCount"),
                    @Result(property ="payType",column = "payType"),
                    @Result(property ="orderDesc",column = "orderDesc"),
                    @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.wugeDao.ProductMapper.getById")),
                    @Result(property ="member",column = "memberId",javaType = Member.class,one = @One(select = "com.wugeDao.MemberMapper.findById")),
                    @Result(property = "travellers" ,column = "id",javaType = java.util.List.class,many = @Many(select = "com.wugeDao.TravellerMapper.findById"))


            }
    )
    Orders findById(int id);
}
