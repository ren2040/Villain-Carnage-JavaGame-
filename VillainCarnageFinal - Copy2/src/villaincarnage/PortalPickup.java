/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villaincarnage;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import java.io.IOException;
import org.jbox2d.common.Vec2;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author Family
 */
public class PortalPickup implements CollisionListener {
     private Villain villain;
     private static SoundClip portalSound; 

Random rand = new Random();

int  n ;

     
       public PortalPickup(Villain villain  ) {
        this.villain = villain;
        
    }
 
     static{
        try{
            portalSound = new SoundClip("data/portalsound.wav");
            System.out.println("Your character has teleported to a new location!");
                   } catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
                       System.out.println(e);
                   }
        // Initialise the SoundClip for Portal sounds.
    }
      @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == villain) {
            portalSound.play();
            // Play sound clip for portal sound
             n = rand.nextInt(30) + 1;
            if (n<10){
               villain.setPosition(new Vec2(14.5f,2f) );
                      }else if (n<20 & n>10 ){
                villain.setPosition(new Vec2(-14.5f,2f));
        }else
                          villain.setPosition(new Vec2(13f,10.5f));
        }
        // Implements the potral object's collision listener. If the player collides with the portal object then
        // the villain object's position will be changed to one of the random exit portal's position
    }
}
