package com.huaibei.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


/**
 * @author xiaolong
 * @date 2024/5/10
 */
@Entity
@Table(name = "tb_user")
@Data
public class User {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "username",unique = true,nullable = false,length = 64)
    private String username;

    @Column(name = "password",nullable = false,length = 64)
    private String password;

    @Column(name = "email",length = 64)
    private String email;
}
