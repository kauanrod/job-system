package com.acme.jobsys.controller

import com.acme.jobsys.JobsysApplication
import com.acme.jobsys.model.Promotion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
@RequestMapping("/promotions")
class PromotionController {
    @Autowired
    lateinit var promotions: ConcurrentHashMap<Long, Promotion>
    
    @RequestMapping(value = ["/sayHello"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String {
        return "Hello World"
    }
    
//    @GetMapping("/promotions")
    @GetMapping
    fun getPromotions(): List<Promotion> {
        return JobsysApplication.initialPromotions.toList()
    }
    
    @GetMapping("/promotions/{id}")
    fun getById(@PathVariable id: Long) = promotions[id]
    
    //alternative to get by id -- just experimenting new stuff
    @GetMapping("/promotions1/{id}")
    fun teste(@PathVariable id: Long): Map<Long, Promotion> {
        return JobsysApplication.initialPromotions.associateBy(Promotion::id)
    }
    
    @PostMapping
    fun create(@RequestBody promotion: Promotion) {
        promotions[promotion.id] = promotion
    }
}