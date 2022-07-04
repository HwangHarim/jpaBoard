package com.postBoard.jpaBoard.Board.application;

import com.postBoard.jpaBoard.Board.converter.BoardConverter;
import com.postBoard.jpaBoard.Board.domain.Board;
import com.postBoard.jpaBoard.Board.dto.reposnse.BoardReadResponse;
import com.postBoard.jpaBoard.Board.dto.request.BoardCreateRequest;
import com.postBoard.jpaBoard.Board.infrastructure.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardReadResponse boardReadResponse;
    private final BoardConverter boardConverter;

    //글 목록 조회
    public List<BoardCreateRequest> getBoards() {
        List<Board> entityList = boardRepository.findAll();
        List<BoardCreateRequest> result = new ArrayList<>();
        for (Board entity : entityList) {
            BoardCreateRequest dto = boardConverter.boardCreateRequest(
                    entity.getId(),
                    entity.getName(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getCreateDateTime(),
                    entity.getModifiedDate());
            result.add(dto);
        }
        return result;
    }

    //글 등록
    public Long addBoard(BoardCreateRequest boardCreateRequest){
        Long insertId = boardRepository.save(boardCreateRequest.toEntity()).
    }


}
