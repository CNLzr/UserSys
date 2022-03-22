package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String loginId;
    private String loginPwd;
    private String name;
    private String email;
    private String age;

    public User(String loginId, String loginPwd, String name, String email, String age) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
