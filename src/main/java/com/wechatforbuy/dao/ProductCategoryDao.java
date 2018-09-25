package com.wechatforbuy.dao;

import com.wechatforbuy.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author CaiShunfeng
 *
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer>{

    /**
     * 通过名字来自定义查询方法(JPA牛逼!)
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}
