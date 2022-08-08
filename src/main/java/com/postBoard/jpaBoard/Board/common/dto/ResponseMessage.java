package com.postBoard.jpaBoard.Board.common.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseMessage {
  CREATE_BOARD_SUCCESS(HttpStatus.CREATED, "BOARD 생성 성공"),
  READ_BOARD_SUCCESS(HttpStatus.OK, "BOARD 검색 성공"),
  READ_ALL_BOARD_SUCCESS(HttpStatus.OK, "BOARD 검색 성공"),
  UPDATE_BOARD_SUCCESS(HttpStatus.OK, "BOARD 수정 성공"),
  DELETE_BOARD_SUCCESS(HttpStatus.OK, "BOARD 삭제 성공");

  private final HttpStatus status;
  private final String message;

  ResponseMessage(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
  }

}
