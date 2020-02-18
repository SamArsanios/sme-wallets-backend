package com.screentech.cordamigrate.entity.user

import com.screentech.cordamigrate.utility.getCurrentSQLDate
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "registrations")
class Registration(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name  = "id") var id : Long,
        @ManyToOne(cascade = arrayOf(CascadeType.MERGE))
        @JoinColumn(name = "user_id") var user : User,
        @Column( name = "industry_type", columnDefinition = "text") var industryType : String?,
        @Column(name = "name", columnDefinition = "text") var name : String?,
        @Column(name = "email", columnDefinition = "text") var email : String?,
        @Column(name = "address", columnDefinition = "text") var address : String?,
        @Column(name = "contact_number", columnDefinition = "text") var contactNumber : String?,
        @Column(name = "city", columnDefinition = "varchar(255)") var city : String?,
        @Column(name = "state", columnDefinition = "text") var state : String?,
        @Column(name = "country", columnDefinition = "text") var country : String?,
        @Column(name = "zip", columnDefinition = "varchar(255)") var zip : String?,
        @Column(name = "cor_address", columnDefinition = "text")   var corAddress : String?,
        @Column(name  = "cor_city", columnDefinition = "text") var corCity : String?,
        @Column(name = "cor_state", columnDefinition = "text") var corState : String?,
        @Column(name = "cor_country", columnDefinition = "text") var corCountry  :String?,
        @Column(name = "cor_zip_code", columnDefinition = "text") var corZipCode : String?,
        @Column(name = "company_name", columnDefinition = "text") var companyName  :String?,
        @Column(name="cr_name", columnDefinition = "text") var crName : String?,
        @Column(name = "company_email", columnDefinition = "text") var companyEmail : String?,
        @Column(name = "company_address", columnDefinition = "text") var companyAddress : String?,
        @Column(name = "the_timestamp",columnDefinition = "timestamp default now() not null") var timestamp : Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr:String?

){
//        override fun toString(): String {
//                return "Registration(id=$id, user=$user, industryType=$industryType, name=$name, email=$email, address=$address, contactNumber=$contactNumber, city='$city', state=$state, country=$country, zip=$zip, corAddress=$corAddress, corCity=$corCity, corState=$corState, corCountry=$corCountry, corZipCode=$corZipCode, companyName=$companyName, crName=$crName, companyEmail=$companyEmail, companyAddress=$companyAddress, timestamp=$timestamp, timestampStr=$timestampStr)"
//        }
}