package com.jungle.board.newBoard.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class NewBoard {
    @Id
    @GeneratedValue
    private Long id;


    private String title;
    private String content;
    private String age;
    private String name;

    public NewBoard() {
    }

    public NewBoard(String title, String content, String age, String name) {
        this.title = title;
        this.content = content;
        this.age = age;
        this.name = name;
    }

}
