package villaincarnage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LavaControl extends KeyAdapter {
   private static   float WALKING_SPEED = 4;
    private Walker body;
    
  public LavaControl(Walker body) {
        this.body = body;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { 
            System.exit(0);
        
          } else if (code == KeyEvent.VK_A ) {
            body.setLinearVelocity(new Vec2(-WALKING_SPEED/2,0)   );
            // Lava object moves leftwards at negative half walking speed of the character
            // Each time the key "A" is pressed
            
        } else if (code == KeyEvent.VK_D) {
            body.setLinearVelocity(new Vec2(WALKING_SPEED/2,0));
             // Lava object moves rightward at positive half walking speed of the character
            // Each time the key "D" is pressed
            
        }
                
        }
     
    public void setWalkingSpeed(){
        WALKING_SPEED =7;
        // Set value of walking speed.
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_1) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_2) {
            body.stopWalking();
        }
        // When either walking keys are released the lava object will stop moving in its respective direction
    }
}