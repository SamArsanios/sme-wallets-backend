package com.screentech.cordamigrate.controller.transactionhistory

import com.screentech.cordamigrate.dao.transactionhistory.TransactionHistoryRepository
import com.screentech.cordamigrate.entity.transactionhistory.TransactionHistory
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/api/smewallets/transactionhistory")
class TransactionHistoryController:CRUDAbstract<TransactionHistory>() {
    @Autowired
    lateinit var transactionHistoryRepository: TransactionHistoryRepository

    @PostMapping("/create")
    override fun create(anObject: TransactionHistory): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        val result = JSONUtilsKT.ok(this.transactionHistoryRepository.save(anObject))
        return result
    }

    @PutMapping("/update")
    fun updateTransactionHistory(@RequestBody transactionHistory: TransactionHistory):ResponseEntity<*>{
        transactionHistory.timestamp = parseStringToTimestamp(transactionHistory.timestampStr)
        val result = JSONUtilsKT.ok(transactionHistoryRepository.save(transactionHistory))
        return result
    }

    @DeleteMapping("/delete")
    fun deleteTransactionHistory(@RequestBody transactionHistory: TransactionHistory): ResponseEntity<*>{
        return JSONUtilsKT.ok(transactionHistoryRepository.delete(transactionHistory))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok(transactionHistoryRepository.findAll())
    }

    @GetMapping("/findById/{Id}")
    override fun deleteById(id: Long): ResponseEntity<*> {
        return JSONUtilsKT.ok(transactionHistoryRepository.findById(id))
    }

}