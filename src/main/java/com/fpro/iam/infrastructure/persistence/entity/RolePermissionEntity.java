package com.fpro.iam.infrastructure.persistence.entity;

import com.fpro.iam.infrastructure.support.constant.ValidateConstraint;
import com.fpro.iam.infrastructure.support.entity.AuditableEntity;
import com.fpro.iam.infrastructure.support.enums.Scope;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_permission", indexes = {
        @Index(name = "role_permission_role_id_idx", columnList = "role_id"),
        @Index(name = "role_permission_resource_code_idx", columnList = "resource_code"),
        @Index(name = "role_permission_scope_idx", columnList = "scope"),
        @Index(name = "role_permission_deleted_idx", columnList = "deleted")
})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class RolePermissionEntity extends AuditableEntity {
    @Id
    @Column(name = "id", length = ValidateConstraint.LENGTH.ID_MAX_LENGTH, nullable = false)
    private String id;

    @Column(name = "role_id", length = ValidateConstraint.LENGTH.ID_MAX_LENGTH, nullable = false)
    private String roleId;

    @Column(name = "resource_code", length = ValidateConstraint.LENGTH.CODE_MAX_LENGTH, nullable = false)
    private String resourceCode;

    @Column(name = "scope", length = ValidateConstraint.LENGTH.ENUM_MAX_LENGTH, nullable = false)
    @Enumerated(EnumType.STRING)
    private Scope scope;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolePermissionEntity that = (RolePermissionEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
