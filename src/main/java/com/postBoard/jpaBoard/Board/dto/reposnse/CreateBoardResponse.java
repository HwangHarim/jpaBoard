package com.postBoard.jpaBoard.Board.dto.reposnse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBoardResponse {
  private String nickName;
  private String title;
  private String content;
}
