package com.screentech.cordamigrate.utility

import com.google.gson.Gson
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class JSONUtilsKT {

    companion object {

        fun toJSON(objectToJSON: Any): Any = Gson().toJson(objectToJSON)

        fun ok(anObject: Any): ResponseEntity<*> = ResponseEntity(Gson().toJson(anObject), HttpStatus.OK)


    }

}


//public static ResponseEntity<?> ok(Object object) {
//    return new ResponseEntity<>(new Gson().toJson(object), HttpStatus.OK);
//}