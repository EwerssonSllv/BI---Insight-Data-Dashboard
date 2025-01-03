package com.ewersson.data_insight_dashbord.services.exceptions

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ObjectNotFoundException(message: String?) : EntityNotFoundException(message)