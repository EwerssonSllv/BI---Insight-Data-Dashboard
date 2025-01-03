package com.ewersson.data_insight_dashbord.model.user.dto

import com.ewersson.data_insight_dashbord.model.user.UserRole
import lombok.Data

@Data
@JvmRecord
data class RegisterDTO(
    val login: String,
    val password: String,
    val role: UserRole
)