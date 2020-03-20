package com.screentech.cordamigrate.entity.roles

import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "roles")
class Roles(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id: Long,
        @Column(name = "name", columnDefinition = "text") var name:String?,
        @Column(name = "guard_name", columnDefinition = "text") var guardName:String?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
)


