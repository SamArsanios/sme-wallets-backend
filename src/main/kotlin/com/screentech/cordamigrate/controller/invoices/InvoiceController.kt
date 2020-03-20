/**
 * @author Daniel Comboni
 *
 * This class exposes REST endpoints for the entity class @class Invoice
 * It extends the @class CRUDAbstract<T> which takes a generic class.
 * The generic class is the entity.
 *
 */

package com.screentech.cordamigrate.controller.invoices

import com.screentech.cordamigrate.dao.invoices.InvoiceRepository
import com.screentech.cordamigrate.entity.invoices.Invoice
import com.screentech.cordamigrate.utility.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/invoices")
class InvoiceController : CRUDAbstract<Invoice>() {

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository


    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate

    /**
     * Parses the string timestamp values of Invoice properties
     *
     * @param anObject an object of type Invoice
     */
    private fun parseTimestamps(anObject: Invoice) : Invoice {
        anObject.theTimestamp = getCurrentTimestampSQL() // parse theTimestamp
//        anObject.invoiceDate = parseStringToTimestamp(anObject.invoiceDateStr)
        anObject.invoiceDueDate = parseStringToTimestamp(anObject.invoiceDueDateStr) // parse the Invoice Due Date
        anObject.sponsor?.emailVerifiedAt = parseStringToTimestamp(anObject.sponsor?.emailVerifiedAtStr) // parse sponsor (User.kt) timestamp
//        anObject.wallet.timestamp = parseStringToTimestamp(anObject.wallet.timestampStr) // parse wallet (Wallet.kt) timestamp
//        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(anObject.wallet.user?.emailVerifiedAtStr) // parse user timestamp in Wallet.kt
        anObject.order?.timestamp = parseStringToTimestamp(anObject.order?.timestampStr) // parse order timestamp
        return anObject // return anObject (Invoice)
    }


    private fun parseTimestampPluggedIn(anObject: Invoice) : Invoice {
        anObject.theTimestamp = parseStringToTimestamp(timestampStr()) // parse theTimestamp
        anObject.invoiceDueDate = parseStringToTimestamp(anObject.invoiceDueDateStr) // parse the Invoice Due Date
        anObject.sponsor.emailVerifiedAt = parseStringToTimestamp(emailVerifiedAtStr()) // parse sponsor (User.kt) timestamp
//        anObject.wallet.timestamp = parseStringToTimestamp(anObject.wallet.timestampStr) // parse wallet (Wallet.kt) timestamp
//        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(anObject.wallet.user?.emailVerifiedAtStr) // parse user timestamp in Wallet.kt
        anObject.order.timestamp = parseStringToTimestamp(timestampStr()) // parse order timestamp
        return anObject // return anObject (Invoice)
    }

    /**
     * Creates / saves an invoice in the database
     * Returns ResponseEntity
     * @param anObject An object of type Invoice
     * @return ResponseEntity
     */
    @PostMapping("/create")
    override fun create(@RequestBody anObject: Invoice): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.invoiceRepository.save(this.parseTimestamps(anObject)))

        this.notificationMessage.convertAndSend("/topic/invoices/create", result)

        return result

    }

    /**
     * updates / saves an invoice in the database
     * Returns ResponseEntity
     * @param anObject An object of type Invoice
     * @return ResponseEntity
     */
    @PutMapping("/update")
    override fun update(@RequestBody anObject: Invoice): ResponseEntity<*>  {

        val result = JSONUtilsKT.ok(this.invoiceRepository.save(parseTimestamps(anObject)))

        this.notificationMessage.convertAndSend("/topic/invoices/update", result)

        return result

    }


    /**
     * deletes a row / record of invoice in the database
     * Returns ResponseEntity
     * @param id An id of the row to be deleted
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    override fun deleteById(id: Long): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.invoiceRepository.deleteById(id))

        this.notificationMessage.convertAndSend("/topic/invoices/delete", result)

        return result

    }

    /**
     * deletes a row /record of invoice in the database.
     * Returns ResponseEntity
     * @param anObject An object of type Invoice
     * @return ResponseEntity
     */
    @DeleteMapping("/delete")
    override fun deleteByObject(@RequestBody anObject: Invoice): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.invoiceRepository.delete(anObject))

//        this.notificationMessage.convertAndSend("/topic/invoices/delete", result)

        return result
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok(invoiceRepository.findAll())
    }

}
