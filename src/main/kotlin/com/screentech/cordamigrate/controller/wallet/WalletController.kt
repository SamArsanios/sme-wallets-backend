package com.screentech.cordamigrate.controller.wallet

import com.screentech.cordamigrate.dao.wallet.WalletRepository
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/wallets")
class WalletController : CRUDAbstract<Wallet>() {

    @Autowired
    lateinit var walletRepository: WalletRepository

    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*>  {

        val result  = JSONUtilsKT.ok(this.walletRepository.findAll())

        this.notificationMessage.convertAndSend("/topic/wallets/findAll", result)

        return result

    }

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.walletRepository.findById(id))

        this.notificationMessage.convertAndSend("/topic/wallets/findById", result)

        return result

    }

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Wallet): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.walletRepository.saveAndFlush(anObject))

        this.notificationMessage.convertAndSend("/topic/wallets/create", result)

        return result

    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Wallet): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.walletRepository.saveAndFlush(anObject))

//         this.notificationMessage.convertAndSend("/topic/wallet/update", result)

        return result

    }

    @DeleteMapping("/delete/{id}")
    override fun deleteById(id: Long): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.walletRepository.deleteById(id))

        this.notificationMessage.convertAndSend("/topic/wallets/delete", result)

        return result

    }

}
