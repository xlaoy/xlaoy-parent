package com.xlaoy.common.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
public interface BaseDao<DOMAIN extends AbstractDomain> {

    @SelectProvider(type = BaseProvider.class, method = "findByIdSql")
    DOMAIN findById(@Param("id") Integer id, @Param("domainClass") Class<DOMAIN> domainClass);

    @SelectProvider(type = BaseProvider.class, method = "findByProperty")
    DOMAIN findByProperty(DOMAIN domain);

}
