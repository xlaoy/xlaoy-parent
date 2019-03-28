package com.xlaoy.user.dao.provider;

import com.xlaoy.user.mapper.Customer;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2019/3/26 0026.
 */
public class CustomerDaoProvider {

    public String createCondition(Customer customer) {
        return new SQL() {
            {
                INSERT_INTO("customer");
                if(!StringUtils.isEmpty(customer.getName())) {
                    VALUES("name", "#{name}");
                }
                if(customer.getAge() != null) {
                    VALUES("age", "#{age}");
                }
            }
        }.toString();
    }
}
