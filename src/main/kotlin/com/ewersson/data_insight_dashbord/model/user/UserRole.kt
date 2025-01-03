package com.ewersson.data_insight_dashbord.model.user

import lombok.Getter

@Getter
enum class UserRole(
    private val role: String) {
    ADMIN("admin"),
    USER("user")
}