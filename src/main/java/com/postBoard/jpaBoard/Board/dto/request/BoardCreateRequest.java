package com.postBoard.jpaBoard.Board.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardCreateRequest {

    private Long id;
    private String name;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

}
