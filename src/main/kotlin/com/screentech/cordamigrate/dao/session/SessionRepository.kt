package com.screentech.cordamigrate.dao.session

import com.screentech.cordamigrate.entity.session.Session
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface SessionRepository : JpaRepository<Session,Long> {

    fun findByUserId(userId : Long) : ResponseEntity<*>

}
