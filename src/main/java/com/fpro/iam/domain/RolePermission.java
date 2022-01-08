package com.fpro.iam.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpro.iam.infrastructure.support.domain.AuditableDomain;
import com.fpro.iam.infrastructure.support.enums.Scope;
import com.fpro.iam.infrastructure.support.util.IdUtils;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Setter(AccessLevel.PRIVATE)
@Getter
public class RolePermission extends AuditableDomain {
    @JsonIgnore
    private String id;
    private String roleId;
    private String resourceCode;
    private Scope scope;
    private Boolean deleted;

    public RolePermission(String roleId, String resourceCode, Scope scope) {
        this.id = IdUtils.nextId();
        this.roleId = roleId;
        this.resourceCode = resourceCode;
        this.scope = scope;
        this.deleted = false;
    }

    public void deleted() {
        this.deleted = true;
    }
}
