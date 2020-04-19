package com.example.model.user;

import com.example.model.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 用户信息
 */
@Data
@Entity
public class UserInfo extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private Integer age;
    private String email;
    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserSexEnum userSex;
}
