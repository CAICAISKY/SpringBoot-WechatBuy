package com.wechatforbuy;

import com.wechatforbuy.dao.ProductCategoryDao;
import com.wechatforbuy.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testFindOne() {
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        System.out.println(productCategory);
    }

    @Test
    /**在测试方法上加@Transactionnal注解可以使测试数据不加入到数据库中*/
    @Transactional
    public void testSave() {
        ProductCategory productCategory = new ProductCategory("SchuylerSave", 4);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() {
        //更新同样是调用save函数，但是需要设置主键，因此一般会先查询对应数据出来
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        productCategory.setCategoryType(3);
        productCategory.setCategoryName("SchuylerOne");
        productCategoryDao.save(productCategory);
    }

    @Test
    public void testDelete() {
        productCategoryDao.deleteById(2);
    }

    @Test
    public void testFindByCategoryTypeIn() {
        List<Integer> types = Arrays.asList(3, 1);
        List<ProductCategory> categories = productCategoryDao.findByCategoryTypeIn(types);
        Assert.assertFalse(categories.size() == 0);
    }
}
