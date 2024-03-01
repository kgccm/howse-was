package com.kjh.boardback.entity.primaryKey;

import com.fasterxml.jackson.core.SerializableString;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoritePk implements Serializable{
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "board_number")
    private int boardNumber;
}
