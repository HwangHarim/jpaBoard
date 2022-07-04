package com.postBoard.jpaBoard.Board.dto.reposnse;

import lombok.Builder;

@Builder
public class BoardReadResponse {
    private final Long id;
    private final String name;
    private final String title;
    private final String content;


}
