package com.ewersson.data_insight_dashbord.model.dashboard

import com.ewersson.data_insight_dashbord.model.sales.Sales
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class Dashboard(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique= true)
    private val id: Int,

    @Column(name = "name")
    private val name: String,


    @Column(name = "description")
    private val description: String,

    @Column(name = "sales")
    private val sales: List<Sales>


) {





}