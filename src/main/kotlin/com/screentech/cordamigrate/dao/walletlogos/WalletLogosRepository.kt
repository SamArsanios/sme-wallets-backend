package com.screentech.cordamigrate.dao.walletlogos

import com.screentech.cordamigrate.entity.wallet.Wallet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface WalletLogosRepository: JpaRepository<Wallet, Long> {
}

