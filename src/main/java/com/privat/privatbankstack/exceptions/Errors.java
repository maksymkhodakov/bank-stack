package com.privat.privatbankstack.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Errors {
    PUBLIC_AND_PRIVATE_KEY_NOT_EXIST("Public and private keys don't exist");
    private final String errorMessage;
}
