package com.ewersson.data_insight_dashbord.model.sales

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class Sales(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique= true)
    private val id: Int,

    @Column(name = "state")
    private val state: String,

    @Column(name = "sale")
    private val sale: Double,

    @Column(name = "average")
    private val average: Double,

    @Column(name = "amount")
    private val amount: Double

) {
}