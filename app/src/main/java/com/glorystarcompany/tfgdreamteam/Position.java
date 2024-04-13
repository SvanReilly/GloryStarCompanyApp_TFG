package com.glorystarcompany.tfgdreamteam;


import androidx.appcompat.app.AppCompatActivity;

public class Position extends AppCompatActivity {
    private Piece piece;


    Position(Piece piece ) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;

    }

    void setPiece(Piece piece) {
        this.piece = piece;
    }

}
