package com.example.shiro.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_role_permission")
public class RolePermission implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "permission_id")
    private Integer permissionId;
}
