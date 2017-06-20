package entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 29.05.2017.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "roles_users")
public class Role extends BaseEntity {

    @Column (name = "role_user")
    @Setter
    @Getter
    private String role;

    public Role(String role) {
        this.role = role;
    }
}
