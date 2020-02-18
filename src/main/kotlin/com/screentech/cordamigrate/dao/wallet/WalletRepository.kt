package com.screentech.cordamigrate.dao.wallet

import com.screentech.cordamigrate.entity.wallet.Wallet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface WalletRepository : JpaRepository<Wallet , Long> {

}