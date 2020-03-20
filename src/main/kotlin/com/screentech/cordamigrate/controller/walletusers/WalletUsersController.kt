package com.screentech.cordamigrate.controller.walletusers

import com.screentech.cordamigrate.dao.walletusers.WalletUsersRepository
import com.screentech.cordamigrate.entity.walletusers.WalletUsers
import com.screentech.cordamigrate.utility.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/walletusers")
class WalletUsersController: CRUDAbstract<WalletUsers>() {
    @Autowired
    lateinit var walletUsersRepository: WalletUsersRepository

    @PostMapping("/create")
    override fun create(anObject: WalletUsers): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        anObject.wallet.timestamp = parseStringToTimestamp(timestampStr())
        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(timestampStr())
        anObject.buyer.emailVerifiedAt = parseStringToTimestamp(timestampStr())

        val result = JSONUtilsKT.ok(walletUsersRepository.save(anObject))
        return result
    }

    @PutMapping("/update")
    fun updateWalletUsers(@RequestBody walletUsers: WalletUsers): ResponseEntity<*>{
        walletUsers.timestamp = parseStringToTimestamp(walletUsers.timestampStr)
        val result = JSONUtilsKT.ok(walletUsersRepository.save(walletUsers))
        return result
    }

    @DeleteMapping("/delete")
    fun deleteWalletUsers(@RequestBody walletUsers: WalletUsers): ResponseEntity<*>{
        return JSONUtilsKT.ok(walletUsersRepository.delete(walletUsers))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok((walletUsersRepository.findAll()))
    }

    @GetMapping("/findById{Id}")
    override fun findById(id: Long): ResponseEntity<*> {
        return JSONUtilsKT.ok(walletUsersRepository.findById(id))
    }
}
