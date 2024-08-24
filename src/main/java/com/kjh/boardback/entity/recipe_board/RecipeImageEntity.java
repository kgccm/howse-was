package com.kjh.boardback.entity.recipe_board;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe_image")
@Table(name = "recipe_image")
public class RecipeImageEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sequence;
    private int boardNumber;
    private String image;
    private int step;


    public RecipeImageEntity(int boardNumber, String image,int step) {
        this.boardNumber = boardNumber;
        this.image = image;
        this.step = step;
    }
}
