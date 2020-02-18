package com.screentech.cordamigrate.utility

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.math.BigDecimal

interface CRUDInterface <T> {

    fun create(anObject : T) :  ResponseEntity<*>

    fun update(anObject: T) : ResponseEntity<*>

    fun findAll() :  ResponseEntity<*>

    fun findById(id: Long) : ResponseEntity<*>

    fun findByEmail(email : String) : ResponseEntity<*>

    fun deleteById(id: Long) : ResponseEntity<*>

    fun deleteByObject(anObject: T) : ResponseEntity<*>
}
