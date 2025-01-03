package com.ewersson.data_insight_dashbord.model.projection

import com.ewersson.data_insight_dashbord.model.sales.Sales

interface DashboardProjection{

    fun getId(): Int

    fun getDescription(): String

    fun getSales(): List<Sales>

}