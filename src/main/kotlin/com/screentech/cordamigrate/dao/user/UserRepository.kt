package com.screentech.cordamigrate.dao.user

import com.screentech.cordamigrate.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface UserRepository : JpaRepository<User, Long> {

    fun findUsersByEmail(email:String) : List<User>

}