package com.fpro.iam.infrastructure.support.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fpro.iam.infrastructure.support.query.response.Response;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represent http response body
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse<T> extends Response<T> {
    private String error;

    @Builder
    public ErrorResponse(int code, String message, T data, String error) {
        this.setData(data);
        this.setCode(code);
        this.setMessage(message);
        this.setSuccess(false);
        this.error = error;
    }
}
