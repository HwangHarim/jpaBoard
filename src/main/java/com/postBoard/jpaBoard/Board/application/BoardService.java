package com.postBoard.jpaBoard.Board.application;

import com.postBoard.jpaBoard.Board.domain.Board;
import com.postBoard.jpaBoard.Board.dto.request.CreateBoardRequest;
import com.postBoard.jpaBoard.Board.dto.request.UpdateBoardRequest;
import com.postBoard.jpaBoard.Board.infrastructure.BoardRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public List<Board> searchAllBoard(Sort sort) {
    return boardRepository.findAll(sort);
  }

  public Optional<Board> searchBoard(Long id){
    return boardRepository.findById(id);
  }
  @Transactional
  public void createBoard(CreateBoardRequest createBoardRequest) {
    boardRepository.save(Board.builder()
        .nickName(createBoardRequest.getNickName())
        .title(createBoardRequest.getTitle())
        .content(createBoardRequest.getContent())
        .build()
    );
  }

  @Transactional
  public void updateBoard(Long id, UpdateBoardRequest updateBoardRequest){
    Board board = boardRepository.findById(id).orElseThrow(()-> {
      throw new NullPointerException();
    });
    board.update(updateBoardRequest.getTitle(), updateBoardRequest.getContent());
  }

  public void deleteBoard(Long id){
    boardRepository.deleteById(id);
  }

  /*paging*/
  @Transactional(readOnly = true)
  public Page<Board> pageList(Pageable pageable){
    return boardRepository.findAll(pageable);
  }
}