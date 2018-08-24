package villaincarnage;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
 
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * extended view
 */
public class MyView4 extends UserView {
    Villain villain;
    
    
    private Image background;
    private Image ballIcon;
    private Image heartIcon;
    
    public MyView4(World world, Villain villain, int width, int height) {
        super(world, width, height);
        this.villain = villain;
        this.background = new ImageIcon("data/game-background4.jpg").getImage();
        //this.ballIcon = new ImageIcon("data/ballIcon.gif").getImage();
        //this.heartIcon = new ImageIcon("data/heartIcon.jpg").getImage();
        
          
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
// Set the background image for level 4 
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Calibri", Font.BOLD,20));
        g.drawString("Villain Carnage",5,30);
        g.setFont(new Font("Calibri", Font.BOLD, 15));
        g.drawString(("Level 1"),20,60);
        
        //g.drawImage(ballIcon, 2,2, this);
         
         
        
        //g.drawImage(heartIcon, 20,40, this);
        g.drawString("Lives left : " + villain.getLives(),20,150);
        g.drawString("Boss Health:"  + villain.getBoss(), 20 , 200);
       
        
    }
    // Sets all the appropriate GUI components for this level, including ball count and 
       // lives count which will be incremented/decremented as the player collides with it's
       // respective object


}