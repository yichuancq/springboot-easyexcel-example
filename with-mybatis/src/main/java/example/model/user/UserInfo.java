package example.model.user;

import lombok.Data;

/**
 * userInfo
 * @author yichuan
 */
@Data
public class UserInfo extends BaseEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String address;
    /**
     * sex
     */
    private UserSexEnum userSex;
}
