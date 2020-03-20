/**
 *
 * @author Daniel Comboni
 *
 */

package com.screentech.cordamigrate.utility

import java.sql.Date
import java.sql.Timestamp
import java.time.Instant

/**
 *
 * Returns the current timestamp.
 *@return Timestamp
 */
fun getCurrentTimeStamp() : Timestamp = Timestamp(System.currentTimeMillis())

fun getCurrentDateFromJavaUtil() : java.util.Date = java.util.Date.from(Instant.now())

fun getCurrentSQLDate() : Date = Date(System.currentTimeMillis())

fun getCurrentTimestampSQL() : Timestamp  = Timestamp.from(Instant.now())

fun parseStringToTimestamp(timestampStr : String?) : Timestamp = Timestamp.valueOf(timestampStr)

/*
* This is used in places that require a timestampStr or even an emailVerifiedAtStr
* */
fun timestampStr() : String = "2020-03-03 10:01:49"

fun emailVerifiedAtStr() : String = timestampStr()

fun invoiceDueDateStr() : String = timestampStr()
//fun main() {
//
//
//    var t = Timestamp.from(Instant.now())
//    println(t)
//    var tt = Timestamp.valueOf("2019-11-19 10:09:55.09\n")
//    println(tt)
//
//    println(parseStringToTimestamp("2019-11-21 10:01:09.626"))
//
////    println(Date.valueOf(tt.toString()))
//
////    println(Date.valueOf(getCurrentTimeStamp().toString()))
////    println(getCurrentTimeStamp())
//////    var date : Date?  =
//////            =
////    println(getCurrentDateFromJavaUtil().toInstant())
////    println("time ${getCurrentDateFromJavaUtil().time}")
////    println("time ${getCurrentDateFromJavaUtil().time}")
////    println("time ${getCurrentDateFromJavaUtil()}")
//
////    println(Date(System.currentTimeMillis()))
//
//}

