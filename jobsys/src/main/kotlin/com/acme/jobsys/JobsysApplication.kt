package com.acme.jobsys

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JobsysApplication

fun main(args: Array<String>) {
	runApplication<JobsysApplication>(*args)
}
