package com.bancopichincha.applicationprogramminginterface.infraestrucutre.http.rest.dto.response.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class ErrorResponse {
    String Error;
}

