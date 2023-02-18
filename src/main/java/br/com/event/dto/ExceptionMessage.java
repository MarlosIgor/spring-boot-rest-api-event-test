package br.com.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionMessage {

    private Long timestamp;
    private int status;
    private String error;
    private String message;

}
