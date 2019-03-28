package com.xlaoy.common.mybatis;

import com.xlaoy.common.exception.BizException;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
public class BaseProvider {

    public String findByIdSql(Map<String, Object> paramar) {
        SQL sql = new SQL();

        //获取表名
        MTable mTable = AnnotationUtils.findAnnotation((Class<?>) paramar.get("domainClass"), MTable.class);
        String table = mTable.name();
        if(StringUtils.isEmpty(table)) {
            throw new BizException("domain实体表名不能为空");
        }
        sql.FROM(table);
        sql.WHERE("id", "#{id}");

        return sql.toString();
    }


    public String findByProperty(AbstractDomain domain) {
        SQL sql = new SQL();

        //获取表名
        MTable mTable = AnnotationUtils.findAnnotation(domain.getClass(), MTable.class);
        String table = mTable.name();
        if(StringUtils.isEmpty(table)) {
            throw new BizException("domain实体表名不能为空");
        }
        sql.FROM(table);
        sql.WHERE("id", "#{id}");

        return sql.toString();
    }
}
