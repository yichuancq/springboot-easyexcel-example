package example.model.user;

import example.model.role.SysRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * userInfo
 *
 * @author yichuan
 */
@Data
@ToString
@Getter
@Setter
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
    /**
     * role
     */
    private List<SysRole> sysRoleList;
}
