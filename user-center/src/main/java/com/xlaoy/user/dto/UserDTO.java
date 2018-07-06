package com.xlaoy.user.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/28 0028.
 */
@Data
public class UserDTO implements Serializable {

    private String userName;

    private String password;

    private String phone;

    private String email;

    private String nickName;
}
