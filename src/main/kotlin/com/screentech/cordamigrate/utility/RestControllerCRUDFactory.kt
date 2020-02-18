//package com.screentech.cordamigrate.utility
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.DeleteMapping
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.PutMapping
//import java.math.BigDecimal
//
//interface RestControllerCRUDFactory<T, Repo> {
//
//
//    @PostMapping("/create")
//    fun create(anObject : T) : ResponseEntity<*> = JSONUtilsKT.ok()
//
//    @PutMapping("/update")
//    fun update(anObject: T ) : ResponseEntity<*>
//
//    @DeleteMapping("/delete/{id}")
//    fun delete(id: BigDecimal) : ResponseEntity<*>
//
//    fun findAll() : ResponseEntity<*>
//
//    fun findById(id : BigDecimal) : ResponseEntity<*>
//
//    fun findByEmail(email : String) : ResponseEntity<*>
//
//}