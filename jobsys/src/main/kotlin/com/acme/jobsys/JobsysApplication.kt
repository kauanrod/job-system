package com.acme.jobsys

import com.acme.jobsys.model.Promotion
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class JobsysApplication {
    companion object {
        val initialPromotions = arrayOf(
            Promotion(
                1,
                "Learn about development and show some results",
                "Intern",
                false,
                1200.00,
                arrayOf(Pair("Meal Voucher", 190.00))
            ),
            Promotion(
                2,
                "Achieve 30 pts and develop front-end",
                "Development Techinician",
                true,
                2400.00,
                arrayOf(Pair("Meal Voucher", 1200.00), Pair("Transport Voucher", 250.00))
            ),
            Promotion(
                3,
                "Achieve 45 pts and develop front-end and begin to develop back-end and solving bugs",
                "Junior Developer I",
                true,
                3000.00,
                arrayOf(Pair("Meal Voucher", 1200.00), Pair("Transport Voucher", 250.00))
            ),
            Promotion(
                4,
                "Achieve 90 pts and develop front-end, back-end, DB and Cloud",
                "Senior Developer I",
                true,
                6000.00,
                arrayOf(Pair("Meal Voucher", 1200.00), Pair("Transport Voucher", 250.00))
            ),
            Promotion(
                5,
                "Manage a development team and deliver some results according to each sprint",
                "Manager",
                false,
                7000.00,
                arrayOf(Pair("Meal Voucher", 1200.00), Pair("Transport Voucher", 250.00))
            ),
        )
    }
    
    @Bean
    fun promotions() = ConcurrentHashMap<Long, Promotion>(initialPromotions.associateBy(Promotion::id))
}

fun main(args: Array<String>) {
    runApplication<JobsysApplication>(*args)
}
