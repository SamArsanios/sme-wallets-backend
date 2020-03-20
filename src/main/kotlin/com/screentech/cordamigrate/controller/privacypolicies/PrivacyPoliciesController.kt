package com.screentech.cordamigrate.controller.privacypolicies

import com.screentech.cordamigrate.dao.privacypolicies.PrivacyPoliciesRepository
import com.screentech.cordamigrate.entity.privacypolicies.PrivacyPolicies
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/smewallets/privacypolicies")
class PrivacyPoliciesController: CRUDAbstract<PrivacyPolicies>(){
    @Autowired
    lateinit var privacyPoliciesRepository: PrivacyPoliciesRepository

    @PostMapping("/create")
    override fun create(anObject: PrivacyPolicies): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        val result = JSONUtilsKT.ok(privacyPoliciesRepository.save(anObject))
        return result
    }

    @PutMapping("/update")
    fun updatePrivacyPolicies(@RequestBody privacyPolicies: PrivacyPolicies): ResponseEntity<*>{
        privacyPolicies.timestamp = parseStringToTimestamp(privacyPolicies.timestampStr)
        val result = JSONUtilsKT.ok(privacyPoliciesRepository.save(privacyPolicies))
        return result
    }

    @DeleteMapping("/delete")
    fun deletePrivacyPolicies(@RequestBody privacyPolicies: PrivacyPolicies): ResponseEntity<*>{
        return JSONUtilsKT.ok(privacyPoliciesRepository.delete(privacyPolicies))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok(privacyPoliciesRepository.findAll())
    }

    @GetMapping("/findById/{Id}")
    override fun deleteById(id: Long): ResponseEntity<*> {
        return JSONUtilsKT.ok(privacyPoliciesRepository.findById(id))
    }

}