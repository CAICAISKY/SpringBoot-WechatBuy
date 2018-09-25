package com.wechatforbuy.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Schuyler
 */
@Entity
/**
 * 我们在创建数据库时，create_time字段和update_time字段是设置为自动更新的，我们在进行数据更新操作时，
 * 往往会先查询目标数据，然后进行修改之后更新，这个时候会因为查询的数据原先就存在的create_time、update_time
 * 导致这两个字段不会自动更新
 * 而@DynamicUpdate就是让实体类
 * 在更新操作时候会自动地对这些自动更新的字段进行动态更新
 */
@DynamicUpdate
/**lombok的注解，自动生成setter和getter而无需再代码中编写*/
@Data
public class ProductCategory {
    @Id
    /**
     * 自动生成有四种类型：
     * TABLE：使用一个特定的数据库表格来保存主键。
     * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     * IDENTITY：主键由数据库自动生成（主要是自动增长型）
     * AUTO：主键由程序控制(默认)，好像也是用了序列。
     * 因为mysql不支持序列，因此我们直接用IDENTITY，否则会报错
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
