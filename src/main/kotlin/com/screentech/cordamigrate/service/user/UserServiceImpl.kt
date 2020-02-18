package com.screentech.cordamigrate.service.user

import com.screentech.cordamigrate.dao.user.UserRepository
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentTimeStamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class UserServiceImpl {

    @Autowired
    lateinit var userRepository: UserRepository

    fun createNewUser(user : User) : User {
//        user.emailVerifiedAt = Date.valueOf(getCurrentTimeStamp().toString())
        return this.userRepository.saveAndFlush(user)
    }

}