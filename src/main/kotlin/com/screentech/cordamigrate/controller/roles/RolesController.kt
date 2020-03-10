package com.screentech.cordamigrate.controller.roles

import com.screentech.cordamigrate.dao.roles.RolesRepository
import com.screentech.cordamigrate.entity.roles.Roles
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/api/smewallets/roles")
class RolesController:CRUDAbstract<Roles>() {
    @Autowired
    lateinit var rolesRepository: RolesRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Roles): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        val result = JSONUtilsKT.ok(this.rolesRepository.save(anObject))
        return result
    }

    @PutMapping("/update")
    fun UpdateRoles(@RequestBody roles:Roles):ResponseEntity<*>{
        roles.timestamp = parseStringToTimestamp(roles.timestampStr)
        val result = JSONUtilsKT.ok(this.rolesRepository.save(roles))
        return result
    }

    @DeleteMapping()

    @GetMapping("/findAll")
    override fun findAll() : ResponseEntity<*> {
//Inline Variable
        return JSONUtilsKT.ok(rolesRepository.findAll())
    }

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {

        return JSONUtilsKT.ok(this.rolesRepository.findById(id))
    }
}