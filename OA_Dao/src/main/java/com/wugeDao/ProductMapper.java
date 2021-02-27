package com.wugeDao;

import com.wugeDomain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
   @Select("select * from product")
   List<Product> findAll();
   @Insert(" INSERT INTO product VALUES (#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus}) ")
   void save(Product product);
   @Select("select *from product where id=#{id}")
   Product getById(int id);

}
