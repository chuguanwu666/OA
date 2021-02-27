package com.wugeService.impl;

import com.wugeDomain.Product;
import com.wugeDao.ProductMapper;
import com.wugeService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;



    @Override
    public List<Product> findAll() {

        System.out.println(mapper.getClass());
        System.out.println(mapper.getClass().getClassLoader());
        List<Product> all = mapper.findAll();
        System.out.println(all.getClass());
        return all;
    }

    @Override
    public void save(Product product) {
        mapper.save(product);
    }
}
