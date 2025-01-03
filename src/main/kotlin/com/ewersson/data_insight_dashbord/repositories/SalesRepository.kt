package com.ewersson.data_insight_dashbord.repositories

import com.ewersson.data_insight_dashbord.model.sales.Sales
import org.springframework.data.jpa.repository.JpaRepository

interface SalesRepository : JpaRepository<Sales, Int>