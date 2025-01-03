package com.ewersson.data_insight_dashbord.model.dashboard

import com.ewersson.data_insight_dashbord.model.sales.Sales
import com.ewersson.data_insight_dashbord.model.user.User
import jakarta.persistence.*

data class Dashboard(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique= true)
    private val id: Int,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private var user: User,

    @Column(name = "name")
    private val name: String,

    @Column(name = "description")
    private val description: String,

    @OneToMany(mappedBy = "user")
    private val sales: List<Sales>? = null

)