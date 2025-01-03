package com.ewersson.data_insight_dashbord.repositories

import com.ewersson.data_insight_dashbord.model.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByLogin(login: String?): UserDetails?
}