package com.falilou.cartrack.web.dtos.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T>{
    private int code;
    private String status;
    private T payload;
    private Object error;
    private Object metadata;
    private Object message;

    public Response(String status, T payload) {
        this.status = status;
        this.payload = payload;
    }
}
