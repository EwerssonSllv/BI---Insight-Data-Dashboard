package com.ewersson.data_insight_dashbord.repository

import com.ewersson.data_insight_dashbord.model.dashboard.Dashboard
import org.springframework.data.jpa.repository.JpaRepository

interface DashboardRepository : JpaRepository<Dashboard, Int>