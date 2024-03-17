package com.salihcanhiz.finalcase.exceptions;

import com.salihcanhiz.finalcase.general.BaseErrorMessage;
import com.salihcanhiz.finalcase.general.N11BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends N11BusinessException {

    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}