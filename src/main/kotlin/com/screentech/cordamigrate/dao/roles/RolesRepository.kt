package com.screentech.cordamigrate.dao.roles

import com.screentech.cordamigrate.entity.roles.Roles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface RolesRepository: JpaRepository<Roles, Long> {
}