package com.screentech.cordamigrate.entity.roles

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.security.Permission
import javax.persistence.*

@Entity
@Table(name = "role_has_permissions")
class RoleHasPermissions (
//        @OneToMany(fetch = FetchType.LAZY) @OnDelete(action = OnDeleteAction.CASCADE)
//        @JoinTable(name = "role_has_permission", joinColumns = arrayOf(JoinColumn(name = "permission_id") , inv))
//        @JoinColumn(name = "permission_id") var permission: Permission?,


        @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinTable(name = "role_has_permissions",
                joinColumns = [JoinColumn(name = "permission_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")])
        var athletes: List<Roles> = mutableListOf()



//@OneToMany(fetch = FetchType.LAZY) @OnDelete(action = OnDeleteAction.CASCADE) @JoinColumn(name = "role_id") var role: Roles?
)

