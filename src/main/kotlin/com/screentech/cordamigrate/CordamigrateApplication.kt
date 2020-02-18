package com.screentech.cordamigrate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class CordamigrateApplication

fun main(args: Array<String>) {
    runApplication<CordamigrateApplication>(*args)
}

