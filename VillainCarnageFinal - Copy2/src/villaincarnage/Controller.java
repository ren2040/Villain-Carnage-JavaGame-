package villaincarnage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException; 


public class Controller extends KeyAdapter {
    private static   float JUMPING_SPEED = 15;
    private static   float WALKING_SPEED = 4;
    private static SoundClip jumpingSound;
    private Walker body;
    
    public Controller(Walker body) {
        this.body = body;
                         
    }
   
    static{
        try{
            jumpingSound = new SoundClip("data/jumpingsound.wav");
            System.out.println("Loading jumping sound");
                   } catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
                       System.out.println(e);
                   }
        // Initialise the SoundClip for JumpingSound.
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { 
            System.exit(0);
            // Quit the game if button "Q" is pressed
        } else if (code == KeyEvent.VK_SPACE) { 
            Vec2 v = body.getLinearVelocity();
            
                      if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                jumpingSound.play();
                // Villain Character jumps upwards if sapce bar is pressed, 
                // Additionally the jumping sound SoundClip will be played each time this occurs
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); 
            // Villain character moves to the left at negative value of walking speed when "A" is held down
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); 
              // Villain character moves to the right at positive value of walking speed when "D" is held down
        }
    }
    public void setWalkingSpeed(){
        WALKING_SPEED =7;
        // Set the walking speed of the character
    }
    
    public void setJumpingSpeed(){
        JUMPING_SPEED = 20;
        // Set the speed the character jumps at
    }
    public void incrementSpeed(){
        WALKING_SPEED = WALKING_SPEED + 5;
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
 
        }
        // Character will stop walking in it's respective direction when the held down key is released
    }
     public void setBody(Walker body) {
        this.body = body;
    }
}