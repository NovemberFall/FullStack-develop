package com.fullstack.auth;

import com.fullstack.customer.CustomerDTO;

public record AuthenticationResponse(String token, CustomerDTO customerDTO) {
}
