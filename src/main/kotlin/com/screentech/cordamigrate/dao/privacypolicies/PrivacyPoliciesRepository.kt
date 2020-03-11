package com.screentech.cordamigrate.dao.privacypolicies

import com.screentech.cordamigrate.entity.privacypolicies.PrivacyPolicies
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface PrivacyPoliciesRepository : JpaRepository<PrivacyPolicies , Long> {

}