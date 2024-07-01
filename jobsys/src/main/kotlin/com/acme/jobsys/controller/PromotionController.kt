package com.acme.jobsys.controller

import com.acme.jobsys.JobsysApplication
import com.acme.jobsys.model.Promotion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromotionController {
    @Autowired
    lateinit var promotions: ConcurrentHashMap<Long, Promotion>
    
    @RequestMapping(value = ["/sayHello"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String {
        return "Hello World"
    }
    
    @GetMapping("/promotions")
    fun getPromotions(): List<Promotion> {
        return JobsysApplication.initialPromotions.toList()
    }
    
    @GetMapping("/promotions/{id}")
    fun getPromotionById(@PathVariable id: Long) = promotions[id]
    
    //it works
    @GetMapping("/promotions1/{id}")
    fun teste(@PathVariable id: Long): Map<Long, Promotion> {
        return JobsysApplication.initialPromotions.associateBy(Promotion::id)
    }
    
    //it doesnt work
    @GetMapping("/promotions2/{id}")
    fun teste2(@PathVariable id: Int): Promotion {
        return JobsysApplication.initialPromotions.get(Promotion::id.toString().toInt())
    }
}