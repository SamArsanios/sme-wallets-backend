package com.screentech.cordamigrate.dao.walletusers

import com.screentech.cordamigrate.entity.walletusers.WalletUsers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface WalletUsers: JpaRepository<WalletUsers, Long> {
}