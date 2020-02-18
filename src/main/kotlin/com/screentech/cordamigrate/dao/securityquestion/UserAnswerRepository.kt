package com.screentech.cordamigrate.dao.securityquestion

import com.screentech.cordamigrate.entity.securityquestion.UserAnswer
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigDecimal

interface UserAnswerRepository : JpaRepository<UserAnswer, Long> {

}