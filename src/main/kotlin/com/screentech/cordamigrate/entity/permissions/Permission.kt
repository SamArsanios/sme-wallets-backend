package com.screentech.cordamigrate.entity.permissions

import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "permissions")
class Permission(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id: Long,
        @Column(name = "name",columnDefinition = "text") var name : String?,
        @Column(name = "guard_name",columnDefinition = "text") var guardName : String?,
        @Column(name = "the_timestamp") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
)
