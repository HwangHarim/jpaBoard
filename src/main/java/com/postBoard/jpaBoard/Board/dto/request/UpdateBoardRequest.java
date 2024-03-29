package com.postBoard.jpaBoard.Board.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBoardRequest {
  private Long id;
  private String title;
  private String content;
}
