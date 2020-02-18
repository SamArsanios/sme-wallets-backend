package com.screentech.cordamigrate.dao.permissions

import com.screentech.cordamigrate.entity.permissions.Permission
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface PermissionRepository : JpaRepository<Permission, Long>{



}