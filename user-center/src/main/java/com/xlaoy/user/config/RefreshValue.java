package com.xlaoy.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/5 0005.
 */
@Data
@RefreshScope
@Component
public class RefreshValue {

    @Value("${gitreponame:}")
    private String gitreponame;

}
