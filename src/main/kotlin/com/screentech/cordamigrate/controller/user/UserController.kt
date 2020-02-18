package com.screentech.cordamigrate.controller.user

import org.springframework.beans.factory.annotation.Autowired
import com.screentech.cordamigrate.dao.user.UserRepository;
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.service.user.UserServiceImpl
import com.screentech.cordamigrate.utility.*
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/users")
class UserController : CRUDAbstract<User>(){

    @Autowired
    lateinit var userServiceImpl: UserServiceImpl

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate


    @PostMapping("/create")
    override fun create(@RequestBody anObject: User): ResponseEntity<*> {

        anObject.emailVerifiedAt = getCurrentTimestampSQL()

        val result = JSONUtilsKT.ok(this.userRepository.save(anObject))

        this.notificationMessage.convertAndSend("/topic/users/create", result)

        return result

    }

    @PutMapping("/update")
    fun updateAUser(@RequestBody user: User) : ResponseEntity<*> {

        user.emailVerifiedAt = parseStringToTimestamp(user.emailVerifiedAtStr)

        val result = JSONUtilsKT.ok(this.userRepository.save(user))

        this.notificationMessage.convertAndSend("/topic/users/update", result)

        return result

    }

    @DeleteMapping("/delete")
    fun deleteAUser(@RequestBody user: User) : ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.userRepository.delete(user))

        this.notificationMessage.convertAndSend("/topic/users/delete", result)

        return result

    }

    @GetMapping("/findAll")
    override fun findAll() : ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.userRepository.findAll())

        this.notificationMessage.convertAndSend("/topic/users/findAll", result)

        return result

    }

    @GetMapping("/findUserByEmail/{email}")
    fun findUserByEmail(@PathVariable email:String) : ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.userRepository.findUsersByEmail(email))

        this.notificationMessage.convertAndSend("/topic/users/findUserByEmail", result)

        return result

    }

}
