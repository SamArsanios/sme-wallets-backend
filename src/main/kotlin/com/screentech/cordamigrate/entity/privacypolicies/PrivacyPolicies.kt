package com.screentech.cordamigrate.entity.privacypolicies

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "privacy_policies")
class PrivacyPolicies (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long,
        @ManyToOne @JoinColumn(name = "user_id") var user: User?,
        @Column(name = "privacy_policy", columnDefinition = "text") var privacyPolicy: String?,
        @Column(name = "terms_conditions", columnDefinition = "text") var termsConditions: String?,
        @Column(name = "notice_of_assignment", columnDefinition = "text") var noticeOfAssignment: String?,
        @Column(name = "payment_authorization", columnDefinition = "text") var paymentAuthorization: String?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
        )

