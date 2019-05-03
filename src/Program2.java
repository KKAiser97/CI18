import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.List;

public class Program2 {
    public static void main(String[]args){
        System.out.println(System.currentTimeMillis());
        long time=System.currentTimeMillis()/1000/60/60/24/365;
        System.out.println(time);
//        employee e1=new employee();
//        e1.eat();

////        Scanner in =new Scanner(System.in);
////        Human person1= new Human(); //de khoi tao
////        person1.eat();
////        person1.sleep();
////        Human person2= new Human("Linh", 24, "male");
        JFrame window = new JFrame();
        GamePanel panel= new GamePanel();
        panel.setBackground(new Color(100, 50, 50));
        panel.setPreferredSize(new Dimension(800, 600));

        window.add(panel);
        window.setTitle("Touhou");
        window.pack();
        //panel.setPreferredSize+window.pack(): tao window om khit panel
//        window.setSize(800, 600);
        window.setResizable(true);
        window.setVisible(true);
        window.setLocation(350, 100);//vi tri man hinh
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KeyAdapter KeyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
               if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP){
                   KeyEventPress.IsUpPress=true;
               }
               if (e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
                    KeyEventPress.IsDownPress=true;
               }
               if (e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT) {
                    KeyEventPress.IsLeftPress=true;
               }
               if (e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    KeyEventPress.IsRightPress=true;
               }
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                super.keyReleased(e);
                //getKeyChar:k bat dc dau cach, tab, ...--->dung getKeyCode
                if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP){
                    KeyEventPress.IsUpPress=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
                    KeyEventPress.IsDownPress=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT)  {
                    KeyEventPress.IsLeftPress=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    KeyEventPress.IsRightPress=false;
                }
            }
        };
        window.addKeyListener(KeyHandler);
        panel.gameloop();
    }
}