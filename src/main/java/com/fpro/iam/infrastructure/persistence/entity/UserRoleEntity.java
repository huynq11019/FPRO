package com.fpro.iam.infrastructure.persistence.entity;

import com.fpro.iam.infrastructure.support.constant.ValidateConstraint;
import com.fpro.iam.infrastructure.support.entity.AuditableEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", indexes = {
        @Index(name = "user_role_user_id_idx", columnList = "user_id"),
        @Index(name = "user_role_role_id_idx", columnList = "role_id"),
        @Index(name = "user_role_deleted_idx", columnList = "deleted")
})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRoleEntity extends AuditableEntity {
    @Id
    @Column(name = "id", length = ValidateConstraint.LENGTH.ID_MAX_LENGTH, nullable = false)
    private String id;

    @Column(name = "user_id", length = ValidateConstraint.LENGTH.ID_MAX_LENGTH, nullable = false)
    private String userId;

    @Column(name = "role_id", length = ValidateConstraint.LENGTH.ID_MAX_LENGTH, nullable = false)
    private String roleId;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
