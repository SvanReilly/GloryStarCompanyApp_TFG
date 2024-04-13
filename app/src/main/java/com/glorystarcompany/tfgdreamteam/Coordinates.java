package com.glorystarcompany.tfgdreamteam;

import androidx.appcompat.app.AppCompatActivity;

public class Coordinates extends AppCompatActivity {

        private int x;
        private int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        void setY(int y) {
            this.y = y;
        }
    }

