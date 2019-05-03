import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;

public class GamePanel extends JPanel {
    BufferedImage playerImage;
    Vector2D playerPostion;
//    double playerX;
//    double playerY;
    BufferedImage bgImage;
    int bgX;
    int bgY;
    public GamePanel(){
        playerImage= SpriteUtils.loadImage("assets/images/players/straight/1.png"); //load anh nhan vat
//        playerX=200;
//        playerY=500;
        playerPostion= new Vector2D(200, 500);
        bgImage=SpriteUtils.loadImage("assets/images/background/0.png"); //load background
        bgX=0;
        bgY=600-bgImage.getHeight();//dai man hinh - dai background
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        super.paint(g);
        g.drawImage(bgImage, bgX, bgY, null);
        g.drawImage(playerImage, (int)playerPostion.x, (int)playerPostion.y, null);
//        g.setColor(Color.YELLOW);
//        g.drawRect(100,100,200,200);
//        g.fillRect(400, 100, 200, 200);

    }
    public void gameloop(){
        long lastTime=0;
        while (true){
//            long currentTime=System.currentTimeMillis();
            long currentTime=System.nanoTime();
            if (currentTime-lastTime>1000000000/60){//tuy chinh fps=60
                System.out.println(currentTime-lastTime);
                //run logic
                this.runAll();
                //render
                this.repaint();
                lastTime=currentTime;
            }
        }
    }
    public  void runAll(){
        //player run
        if (KeyEventPress.IsUpPress) {playerPostion.y--;}
//        playerX++;
        if (KeyEventPress.IsDownPress) {playerPostion.y++;}
        if (KeyEventPress.IsRightPress) {playerPostion.x++;}
        if (KeyEventPress.IsLeftPress) {playerPostion.x--;}
        //bg run
        bgY++;
        if (bgY>=0) {
            bgY = 600-3109;
        }
//        if (playerX>=bgImage.getWidth()-playerImage.getWidth()) {
//            playerX=0;
//        }

        playerPostion.x= Mathx.clamp(playerPostion.x, 0, bgImage.getWidth()-playerImage.getWidth());
        playerPostion.y= Mathx.clamp(playerPostion.y, 0, 600-playerImage.getHeight());


    }
}
