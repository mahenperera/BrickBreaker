import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlayVersus extends JPanel implements KeyListener{

    //ball 1
    private int Ball1X=1100;
    private int Ball1Y=600;
    private boolean ball1Xplus=true;
    private boolean ball1Yplus=false;
    //ball 2
    private int Ball2X=100;
    private int Ball2Y=200;
    private boolean ball2Xplus=true;
    private boolean ball2Yplus=true;

    //paddle 1
    private int player1X=600;
    private int player1Y=680;
    //paddle 2
    private int player2X=600;
    private int player2Y=10;

    private boolean play=true;
    private int playerX=200;
    private int offset =50;
    private int score1 =0;
    private int score2 =0;
    private int timer =0;
    private boolean cooldown = false;
    private boolean cooldown1 = false;
    private int brickposX[]={440,540,640,740,840,440,540,640,740,840};

    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1280, 720);
        g2d.setColor(Color.RED);
        g2d.fillOval(Ball1X, Ball1Y, 30, 30);
        g2d.fillRect(player1X,player1Y, 200,5);
        g2d.setColor(Color.GREEN);
        g2d.fillOval(Ball2X, Ball2Y, 30, 30);
        g2d.fillRect(player2X,player2Y, 200,5);

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

        //ball 1
        Rectangle ball1 = new Rectangle();   
        ball1.setSize(30,30);
        ball1.setLocation(Ball1X, Ball1Y);

        //ball 2
        Rectangle ball2 = new Rectangle();
        ball2.setSize(30,30);
        ball2.setLocation(Ball2X, Ball2Y);

        //paddle 1
        Rectangle player1 = new Rectangle();
        player1.setSize(200,5);
        player1.setLocation(player1X, player1Y);

        //paddle 2
        Rectangle player2 = new Rectangle();
        player2.setSize(200,5);
        player2.setLocation(player2X, player2Y);

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

            if(Ball2X>1250 | 0>Ball2X){
                ball2Xplus^= true;
            }else if(Ball2Y>680){
                ball2Yplus^= true;
            }else if(ball2.intersects(player2)){
                ball2Yplus^= true;
            }

            if(ball2Xplus==true){
                Ball2X++;
            }else{
                Ball2X--;
            }

            if(ball2Yplus==true){
                Ball2Y++;
            }else{
                Ball2Y--;
            }
            
            if(player1Y<520){
                player1Y=520;
            }else if(player2Y>200){
                player2Y=200;
            }

            //ball 1 brick collision
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

            //ball 2 brick collision
            if(ball2.intersects(brick0)&cooldown1==false){
                brickposX[0]=1400;
                ball2Yplus^= true;
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick1)&cooldown1==false){
                brickposX[1]=1400;
                ball2Yplus^= true;
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick2)&cooldown1==false){
                brickposX[2]=1400;
                ball2Yplus^= true;
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick3)&cooldown1==false){
                brickposX[3]=1400;
                ball2Yplus^= true;
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick4)&cooldown1==false){
                brickposX[4]=1400;
                ball2Yplus^= true;
                score2+=100;    
                cooldown1=true;
            }else if(ball2.intersects(brick5)&cooldown1==false){
                brickposX[5]=1400;
                ball2Yplus^= true;
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick6)&cooldown1==false){
                brickposX[6]=1400;
                ball2Yplus^= true;
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick7)&cooldown1==false){
                brickposX[7]=1400;
                ball2Yplus^= true;
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick8)&cooldown1==false){
                brickposX[8]=1400;   
                ball2Yplus^= true; 
                score2+=100;
                cooldown1=true;
            }else if(ball2.intersects(brick9)&cooldown1==false){
                brickposX[9]=1400;   
                ball2Yplus^= true; 
                score2+=100;
                cooldown1=true;
            }

            if(cooldown==true|cooldown1==true){
                timer++;
            }

            if(timer>10){
                cooldown=false;
                cooldown1=false;
                timer=0;
            }
        }

        if(score1+score2==1000){
            g2d.setFont(new Font("Papyrus", 1, 72)); 
            g2d.drawString("Game Over", 450, 250);
            g2d.setFont(new Font("Papyrus", 1, 25));
            if(score1>score2){
                g2d.drawString("Player 1 Wins!!! \nScore: "+score1, 450, 350);
            }else{
                g2d.drawString("Player 2 Wins!!! \nScore: "+score2, 450, 350);
            }
        }else if(Ball2Y<0){
            play=false;
            g2d.setFont(new Font("Papyrus", 1, 72)); 
            g2d.drawString("Game Over", 450, 250);
            g2d.setFont(new Font("Papyrus", 1, 25));
            g2d.drawString("Player 2 fell, Player 1 Wins!!! ", 450, 350);
        }else if(Ball1Y>680){
            play=false;
            g2d.setFont(new Font("Papyrus", 1, 72)); 
            g2d.drawString("Game Over", 450, 250);
            g2d.setFont(new Font("Papyrus", 1, 25));
            g2d.drawString("Player 1 fell, Player 2 Wins!!! ", 450, 350);
        }else{
            g2d.setFont(new Font("Serif", 1, 20)); 
            g2d.setColor(Color.WHITE);
            g2d.drawString("Player 1: "+score1, 10, 380);
            g2d.drawString("Player 2: "+score2, 10, 340);
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
            case KeyEvent.VK_RIGHT: player2X+=100;
                break;
            case KeyEvent.VK_LEFT :player2X-=100;
                break;
            case KeyEvent.VK_DOWN: player2Y+=75;
                break;
            case KeyEvent.VK_UP: player2Y-=75;
                break;
            case KeyEvent.VK_ENTER: play^= true; 
                break;
        }
    }
}