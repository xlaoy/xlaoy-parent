package com.xlaoy.user.dao;

import com.xlaoy.user.dao.provider.CustomerDaoProvider;
import com.xlaoy.user.mapper.Customer;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2019/3/25 0025.
 */
@Mapper
public interface CustomerDao {

    @Insert("insert into customer(name, age) values(#{name}, #{age})")
    void insert(Customer customer);


    @InsertProvider(type = CustomerDaoProvider.class, method = "createCondition")
    void insertAny(Customer customer);


    @Select("select name, age from customer where name = #{name}")
    @Results(id = "customer_map", value = {
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age")
    })
    Customer findByName(String name);
}
