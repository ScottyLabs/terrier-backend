package com.terrier.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceApplication

fun main(args: Array<String>) {
    runApplication<ServiceApplication>(*args)
}
