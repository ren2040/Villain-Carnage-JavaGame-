package villaincarnage;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
 
import java.awt.Color;
import java.awt.Font;
import org.jbox2d.common.Timer;

/**
 * extended view
 */
public class MyView extends UserView {
    Villain villain;
     
    
    private Image background;
    private Image ballIcon;
    private Image heartIcon;
    
    
    public MyView(World world, Villain villain, int width, int height) {
        super(world, width, height);
        this.villain = villain;
        this.background = new ImageIcon("data/game-background.jpg").getImage(); 
        
    }
      
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
// Apply the required background for level 1 from the data directory
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Calibri", Font.BOLD,20));
        g.drawString("Villain Carnage",5,30);
        g.setFont(new Font("Calibri", Font.BOLD, 15));
        g.drawString(("Level 1"),20,60);
        
         
        
        //g.drawImage(ballIcon, 2,2, this);
         
        g.drawString("Ball Count :" + villain.getBallCount(), 20,120 );
        
        //g.drawImage(heartIcon, 20,40, this);
        g.drawString("Lives left : " + villain.getLives(),20,150);
         
       // Sets all the appropriate GUI components for this level, including ball count and 
       // lives count which will be incremented/decremented as the player collides with it's
       // respective object
       
    }


}
