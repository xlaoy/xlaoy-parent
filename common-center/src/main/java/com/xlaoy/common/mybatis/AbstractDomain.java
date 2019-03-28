package com.xlaoy.common.mybatis;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Created by xlaoy on 2017/12/23 0023.
 */
@Data
public abstract class AbstractDomain implements Serializable {

    protected Integer id;

}
