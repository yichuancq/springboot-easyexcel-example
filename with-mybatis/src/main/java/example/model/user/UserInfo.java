package example.model.user;

import lombok.Data;
import lombok.ToString;

/**
 * userInfo
 *
 * @author yichuan
 */
@Data
@ToString
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
