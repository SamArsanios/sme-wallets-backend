package com.screentech.cordamigrate.controller.walletlogos

import com.screentech.cordamigrate.dao.walletlogos.WalletLogosRepository
import com.screentech.cordamigrate.entity.walletlogos.WalletLogos
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("api/smewallets/walletlogos")
class WalletLogosController:CRUDAbstract<WalletLogos>(){
    @Autowired
    lateinit var walletLogosRepository: WalletLogosRepository

    @PostMapping("/create")
    override fun create(anObject: WalletLogos): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        val result = JSONUtilsKT.ok(walletLogosRepository.save(anObject))
        return result
    }

    @PutMapping("/update")
    fun updateWalletLogos(@RequestBody walletLogos: WalletLogos): ResponseEntity<*> {
        walletLogos.timestamp = parseStringToTimestamp(walletLogos.timestampStr)
        val result = JSONUtilsKT.ok(walletLogosRepository.save(walletLogos))
        return result
    }

    @DeleteMapping("/delete")
    fun deleteWalletLogos(@RequestBody walletLogos: WalletLogos): ResponseEntity<*> {
        return JSONUtilsKT.ok(walletLogosRepository.delete(walletLogos))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok((walletLogosRepository.findAll()))
    }

    @GetMapping("/findById{Id}")
    override fun findById(id: Long): ResponseEntity<*> {
        return JSONUtilsKT.ok(walletLogosRepository.findById(id))
    }
}