package com.nuxplanet.library.customer.domain;

import com.nuxplanet.library.common.exception.BaseException;
import com.nuxplanet.library.common.exception.ErrorCode;

/**
 * @author oleciwoj
 */
public class CustomerException extends BaseException {
    public CustomerException(ErrorCode code, String message) {
        super(code, message);
    }

    public CustomerException(ErrorCode code, int httpStatusCode) {
        super(code, httpStatusCode);
    }

    public CustomerException(ErrorCode code, int httpStatusCode, String message) {
        super(code, httpStatusCode, message);
    }

    public CustomerException(ErrorCode code, int httpStatusCode, String message, Throwable cause) {
        super(code, httpStatusCode, message, cause);
    }
}
