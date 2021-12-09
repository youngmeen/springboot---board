package com.jungle.board.newBoard.controller;

import com.jungle.board.newBoard.entity.NewBoard;
import com.jungle.board.newBoard.entity.NewBoardRepository;
import com.jungle.board.newBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
    private NewBoardRepository boardRep;
    private BoardService boardService;

    @Autowired
    public BoardController(NewBoardRepository boardRep) {
        this.boardRep = boardRep;
    }

    

    //post 유저 추가
    @PostMapping
    public NewBoard put(@RequestParam("title")String title, @RequestParam("content")String content, @RequestParam("name")String name, @RequestParam("age")String age){
        return boardRep.save(new NewBoard(title, content, name, age));
    }

    //테이블 리스트 가져오기
    @GetMapping
    public Iterable<NewBoard> list(){
        return boardRep.findAll();
    }

    //id로 테이블 값 가져오기
    @GetMapping(value = "/{id}")
    public Optional<NewBoard> findOne(@PathVariable Long id){
        return boardRep.findById(id);
    }

    //id로 테이블 값 수정
    @PutMapping(value = "/{id}")
    public NewBoard update(@PathVariable Long id, @RequestParam String name, @RequestParam String age){
        Optional<NewBoard> newBoard = boardRep.findById(id);
        newBoard.get().setName(name);
        newBoard.get().setAge(age);
        return boardRep.save(newBoard.get());
    }





}
