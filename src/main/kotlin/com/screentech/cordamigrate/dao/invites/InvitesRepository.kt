package com.screentech.cordamigrate.dao.invites

import com.screentech.cordamigrate.entity.invites.Invite
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import java.math.BigDecimal

interface InvitesRepository : JpaRepository<Invite, Long> {
    fun findByEmail(email : String) : ResponseEntity<*>
}