package com.falilou.cartrack.web.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Response<T>{
    private Object message;
    private T payload;
    private String status;
    private int code;

    public Response(String message, T payload, String status) {
        this.message = message;
        this.payload = payload;
        this.status = status;
    }

    public static <T> Response<T> ok() {
        Response<T> response =new Response<>();
        response.setStatus("OK");
        return response;
    }

}
