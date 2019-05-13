package Game.Enemy;

import Game.GameObject;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy(){
        position.set(100,-1500);
        image= SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
    }
    @Override
    public void run() {
        this.position.y++;
        this.position.x++;
        if (this.position.x ==359) {
            this.position.x--;
        }
        this.disappear();
    }
    private void disappear() {
        if (this.position.y == -2000) {
            this.deactive();
        }
    }
}
