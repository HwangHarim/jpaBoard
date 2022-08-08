package com.postBoard.jpaBoard.Board.common.converter;

import com.postBoard.jpaBoard.Board.common.dto.ResponseDto.ResponseDtoV1;
import com.postBoard.jpaBoard.Board.common.dto.ResponseDto.ResponseDtoV2;
import com.postBoard.jpaBoard.Board.common.dto.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {
  public ResponseEntity<ResponseDtoV1> toResponseEntity(ResponseMessage message){
    return ResponseEntity
        .status(message.getStatus())
        .body(
          new ResponseDtoV1(message)
        );
  }

  public <T> ResponseEntity<ResponseDtoV2<T>> toResponseEntity(ResponseMessage message, T date){
    return ResponseEntity
        .status(message.getStatus())
        .body(
          new ResponseDtoV2<>(message, date)
        );
  }
}
