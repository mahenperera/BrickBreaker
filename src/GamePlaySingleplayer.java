import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlaySingleplayer extends JPanel implements KeyListener{

    //ball
    private int Ball1X=1100;
    private int Ball1Y=600;
    private boolean ball1Xplus=true;
    private boolean ball1Yplus=false;

    //paddle
    private int player1X=600;
    private int player1Y=680;

    private boolean play=true;
    private int score1 = 0;
    private int timer = 0;
    private int gametimer = 0;
    private boolean cooldown = false;

    private int brickposX[]={440,540,640,740,840,440,540,640,740,840};

    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1280, 720);
        g2d.setColor(Color.RED);
        g2d.fillOval(Ball1X, Ball1Y, 30, 30);
        g2d.fillRect(player1X,player1Y, 200,5);

        //brick draw
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(brickposX[0], 360, 50, 50);
        g2d.fillRect(brickposX[1], 360, 50, 50);
        g2d.fillRect(brickposX[2], 360, 50, 50);
        g2d.fillRect(brickposX[3], 360, 50, 50);
        g2d.fillRect(brickposX[4], 360, 50, 50);
        
        g2d.fillRect(brickposX[5], 260, 50, 50);
        g2d.fillRect(brickposX[6], 260, 50, 50);
        g2d.fillRect(brickposX[7], 260, 50, 50);
        g2d.fillRect(brickposX[8], 260, 50, 50);
        g2d.fillRect(brickposX[9], 260, 50, 50);

        //ball
        Rectangle ball1 = new Rectangle();   
        ball1.setSize(30,30);
        ball1.setLocation(Ball1X, Ball1Y);

        //paddle
        Rectangle player1 = new Rectangle();
        player1.setSize(200,5);
        player1.setLocation(player1X, player1Y);

        //bricks
        Rectangle brick0 = new Rectangle();
        brick0.setSize(50,50);
        brick0.setLocation(brickposX[0], 360);

        Rectangle brick1 = new Rectangle();
        brick1.setSize(50,50);
        brick1.setLocation(brickposX[1], 360);

        Rectangle brick2 = new Rectangle();
        brick2.setSize(50,50);
        brick2.setLocation(brickposX[2], 360);

        Rectangle brick3 = new Rectangle();
        brick3.setSize(50,50);
        brick3.setLocation(brickposX[3], 360);

        Rectangle brick4 = new Rectangle();
        brick4.setSize(50,50);
        brick4.setLocation(brickposX[4], 360);

        Rectangle brick5 = new Rectangle();
        brick5.setSize(50,50);
        brick5.setLocation(brickposX[5], 260);

        Rectangle brick6 = new Rectangle();
        brick6.setSize(50,50);
        brick6.setLocation(brickposX[6], 260);

        Rectangle brick7 = new Rectangle();
        brick7.setSize(50,50);
        brick7.setLocation(brickposX[7], 260);

        Rectangle brick8 = new Rectangle();
        brick8.setSize(50,50);
        brick8.setLocation(brickposX[8], 260);

        Rectangle brick9 = new Rectangle();
        brick9.setSize(50,50);
        brick9.setLocation(brickposX[9], 260);
        
        if(play==true){
            gametimer++;

            if(Ball1X>1250 | 0>Ball1X){
                ball1Xplus^= true;
            }else if(0>Ball1Y){
                ball1Yplus^= true;
            }else if(ball1.intersects(player1)){
                ball1Yplus^= true;
            }

            if(ball1Xplus==true){
                Ball1X++;
            }else{
                Ball1X--;
            }

            if(ball1Yplus==true){
                Ball1Y++;
            }else{
                Ball1Y--;
            }

            if(player1Y<520){
                player1Y=520;
            }

            //brick collision
            if(ball1.intersects(brick0)&cooldown==false){
                brickposX[0]=1400;
                ball1Yplus^= true;
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick1)&cooldown==false){
                brickposX[1]=1400;
                ball1Yplus^= true;
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick2)&cooldown==false){
                brickposX[2]=1400;
                ball1Yplus^= true;
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick3)&cooldown==false){
                brickposX[3]=1400;
                ball1Yplus^= true;
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick4)&cooldown==false){
                brickposX[4]=1400;   
                ball1Yplus^= true; 
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick5)&cooldown==false){
                brickposX[5]=1400;
                ball1Yplus^= true;
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick6)&cooldown==false){
                brickposX[6]=1400;
                ball1Yplus^= true;
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick7)&cooldown==false){
                brickposX[7]=1400;
                ball1Yplus^= true;
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick8)&cooldown==false){
                brickposX[8]=1400;   
                ball1Yplus^= true; 
                score1+=100;
                cooldown=true;
            }else if(ball1.intersects(brick9)&cooldown==false){
                brickposX[9]=1400;   
                ball1Yplus^= true; 
                score1+=100;
                cooldown=true;
            }

            if(cooldown==true){
                timer++;
            }

            if(timer>10){
                cooldown=false;
                timer=0;
            }
        
        }

        if(score1==1000){
            play=false;
            g2d.setFont(new Font("Papyrus", 1, 45)); 
            g2d.drawString("ALL BRICKS KNOCKED OUT", 250, 250);
            g2d.setFont(new Font("Papyrus", 1, 25));
            g2d.drawString("Score: "+(score1-(gametimer/50)), 10, 380);
        }else if(Ball1Y>680){
            play=false;
            g2d.setFont(new Font("Papyrus", 1, 45)); 
            g2d.drawString("GAME OVER", 450, 250);
            g2d.setFont(new Font("Papyrus", 1, 25));
            g2d.drawString("Ball fell", 450, 350);
        }else{
            g2d.setFont(new Font("Serif", 1, 20)); 
            g2d.setColor(Color.WHITE);
            g2d.drawString("Score: "+(score1-(gametimer/50)), 10, 380);
        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'd': player1X+=100;
                break;
            case 'a' :player1X-=100;
                break;
            case 's': player1Y+=75;
                break;
            case 'w': player1Y-=75;
                break;
        }
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT: player1X+=100;
                break;
            case KeyEvent.VK_LEFT :player1X-=100;
                break;
            case KeyEvent.VK_DOWN: player1Y+=75;
                break;
            case KeyEvent.VK_UP: player1Y-=75;
                break;
            case KeyEvent.VK_ENTER: play^= true; 
                break;
        }
    }
}