package com.screentech.cordamigrate.controller.permissions

import com.screentech.cordamigrate.dao.permissions.PermissionRepository
import com.screentech.cordamigrate.entity.permissions.Permission
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/permissions")
class PermissionController : CRUDAbstract<Permission>() {

    @Autowired
    lateinit var permissionRepository: PermissionRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Permission): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        return JSONUtilsKT.ok(this.permissionRepository.save(anObject))
    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Permission): ResponseEntity<*> {
        anObject.timestamp = parseStringToTimestamp(anObject.timestampStr)
        return  JSONUtilsKT.ok(this.permissionRepository.save(anObject))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> = JSONUtilsKT.ok(this.permissionRepository.findAll())

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> = JSONUtilsKT.ok(this.permissionRepository.findById(id))

}
