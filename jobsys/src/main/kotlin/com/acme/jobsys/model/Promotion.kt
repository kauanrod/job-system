package com.acme.jobsys.model

data class Promotion(
    val id: Long,
    val description: String,
    val role: String,
    val gotABonus: Boolean,
    val salary: Double,
    val benefits: Array<Pair<String, Double>>
)