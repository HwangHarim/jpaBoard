package com.postBoard.jpaBoard.Board.converter;

import com.postBoard.jpaBoard.Board.dto.request.BoardCreateRequest;

import java.time.LocalDateTime;

public class BoardConverter {

    public BoardCreateRequest boardCreateRequest(Long id, String name, String title, String content, LocalDateTime createDateTime, LocalDateTime modifiedDate){
        return BoardCreateRequest.builder()
                .id(id)
                .name(name)
                .title(title)
                .content(content)
                .createDate(createDateTime)
                .modifiedDate(modifiedDate)
                .build();
    }
}
