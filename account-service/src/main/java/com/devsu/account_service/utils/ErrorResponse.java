package com.devsu.account_service.utils;

import java.time.LocalDateTime;

public record ErrorResponse(String message, LocalDateTime timestamp) {

}
