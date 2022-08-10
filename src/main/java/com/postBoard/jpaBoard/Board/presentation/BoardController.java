package com.postBoard.jpaBoard.Board.presentation;

import com.postBoard.jpaBoard.Board.application.BoardService;
import com.postBoard.jpaBoard.Board.common.converter.ResponseConverter;
import com.postBoard.jpaBoard.Board.common.dto.ResponseDto.ResponseDtoV1;
import com.postBoard.jpaBoard.Board.common.dto.ResponseDto.ResponseDtoV2;
import com.postBoard.jpaBoard.Board.common.dto.ResponseMessage;
import com.postBoard.jpaBoard.Board.domain.Board;
import com.postBoard.jpaBoard.Board.dto.request.CreateBoardRequest;
import com.postBoard.jpaBoard.Board.dto.request.UpdateBoardRequest;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;
  private final ResponseConverter responseConverter;

  @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
  public ResponseEntity<ResponseDtoV2<List<Board>>> getAllBoard(){
    List<Board> boards = boardService.searchAllBoard(Sort.by(Direction.ASC, "id"));
    return responseConverter.toResponseEntity(
      ResponseMessage.READ_ALL_BOARD_SUCCESS,
      boards
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseDtoV2<Optional<Board>>> findIdBoard(@PathVariable("id") Long id){
    Optional<Board> board = boardService.searchBoard(id);
    return responseConverter.toResponseEntity(
      ResponseMessage.READ_BOARD_SUCCESS,
      board
    );
  }

  @PostMapping
  public ResponseEntity<ResponseDtoV1> createBoard(@RequestBody CreateBoardRequest createBoardRequest){
    boardService.createBoard(createBoardRequest);
    return responseConverter.toResponseEntity(ResponseMessage.CREATE_BOARD_SUCCESS);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ResponseDtoV1> updateBoard(@PathVariable("id") Long id, @RequestBody UpdateBoardRequest updateBoardRequest){
    boardService.updateBoard(id, updateBoardRequest);
    return responseConverter.toResponseEntity(ResponseMessage.UPDATE_BOARD_SUCCESS);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDtoV1> deleteBoard(@PathVariable Long id){
    boardService.deleteBoard(id);
    return responseConverter.toResponseEntity(ResponseMessage.DELETE_BOARD_SUCCESS);
  }

  @GetMapping
  public ResponseEntity<ResponseDtoV2<Page<Board>>> index(@PageableDefault(sort="id", direction = Direction.DESC) Pageable pageable){
    Page<Board> boards = boardService.pageList(pageable);
    return responseConverter.toResponseEntity(
      ResponseMessage.READ_ALL_BOARD_SUCCESS,
      boards
    );
  }

  @GetMapping("/search")
  public ResponseEntity<ResponseDtoV2<List<Board>>> search(String title) {
    List<Board> boards = boardService.keywordSearch(title);
    return responseConverter.toResponseEntity(
        ResponseMessage.READ_BOARD_SUCCESS,
        boards
    );
  }
}