package com.screentech.cordamigrate.utility

import org.springframework.http.ResponseEntity
import java.math.BigDecimal

 abstract class CRUDAbstract<T> : CRUDInterface<T> {

     override fun create(anObject: T): ResponseEntity<*> {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun update(anObject: T): ResponseEntity<*> {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun findAll(): ResponseEntity<*> {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun findById(id: Long): ResponseEntity<*> {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun findByEmail(email: String): ResponseEntity<*> {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun deleteById(id: Long): ResponseEntity<*> {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun deleteByObject(anObject: T): ResponseEntity<*> {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

 }
