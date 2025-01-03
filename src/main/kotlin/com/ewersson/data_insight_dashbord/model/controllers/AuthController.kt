package com.ewersson.data_insight_dashbord.model.controllers

import com.ewersson.data_insight_dashbord.config.TokenService
import com.ewersson.data_insight_dashbord.model.user.User
import com.ewersson.data_insight_dashbord.model.user.dto.AuthenticationDTO
import com.ewersson.data_insight_dashbord.model.user.dto.LoginResponseDTO
import com.ewersson.data_insight_dashbord.model.user.dto.RegisterDTO
import com.ewersson.data_insight_dashbord.repositories.UserRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class AuthenticationController @Autowired constructor(
    private val authenticationManager: AuthenticationManager,
    private val repository: UserRepository,
    private val tokenService: TokenService,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    @PostMapping("/login")
    fun login(@RequestBody data: @Valid AuthenticationDTO): ResponseEntity<LoginResponseDTO> {
        val usernamePassword = UsernamePasswordAuthenticationToken(data.login, data.password)
        val auth = authenticationManager.authenticate(usernamePassword)

        val token = tokenService.generateToken(auth.principal as User)

        return ResponseEntity.ok(LoginResponseDTO(token))
    }

    @PostMapping("/register")
    fun register(@RequestBody data: @Valid RegisterDTO): ResponseEntity<Any> {
        if (repository.findByLogin(data.login) != null) return ResponseEntity.badRequest().build<Any>()

        val encryptedPassword = passwordEncoder.encode(data.password)
        val newUser = User(data.login, encryptedPassword, data.role)

        repository.save(newUser)

        return ResponseEntity.ok().build<Any>()
    }
}