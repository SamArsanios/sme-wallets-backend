package com.screentech.cordamigrate.utility;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JSONUtils {

    private JSONUtils() {

    }

    /**
     * changes the object a JSON
     *
     * @param objectToJSON
     * @return JSOn (String)
     */
    public static Object toJSON(Object objectToJSON) {
        return new Gson().toJson(objectToJSON);
    }

    /**
     * Returns a message (wrong) and bad request (400)
     *
     * @return {@link ResponseEntity}
     */
    public static ResponseEntity<?> badRequest() {
        return new ResponseEntity<>(new Gson().toJson(new String("wrong")), HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns OK HTTP Status and a body
     *
     * @param object
     * @return {@link ResponseEntity}
     */
    public static ResponseEntity<?> ok(Object object) {
        return new ResponseEntity<>(new Gson().toJson(object), HttpStatus.OK);
    }


}
