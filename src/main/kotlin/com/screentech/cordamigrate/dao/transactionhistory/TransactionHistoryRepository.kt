package com.screentech.cordamigrate.dao.transactionhistory

import com.screentech.cordamigrate.entity.transactionhistory.TransactionHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface TransactionHistoryRepository: JpaRepository<TransactionHistory, Long> {
}


