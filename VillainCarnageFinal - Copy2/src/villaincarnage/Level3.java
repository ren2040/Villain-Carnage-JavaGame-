/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villaincarnage;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Family
 */
public class Level3 extends GameLevel{
private SoundClip  gameMusic;
private Portal portal;
private Portal portal2;
private Portal exit;
private Portal exit2;
private int ballSpaceX = -13 ;
private int ballSpaceY = 1 ;
private int ballSpaceX2 = 12;
private int ballSpaceY2 = 8;
private int ballSpaceX3 = 14;
private int ballSpaceY3 = 0;
   @Override
    public void populate(VillainCarnage villainCarnage ) {
        super.populate(villainCarnage );
        
        
 
         
         
         Shape platformShape1 = new BoxShape(0.25f,15f);
         Shape platformShape2 = new BoxShape(1f,0.25f);
        Body  platform1 = new StaticBody(this,platformShape1 );
        platform1.setPosition(new Vec2(14.5f,7f));
        platform1.setAngleDegrees(-45);
        platform1.setFillColor(Color.blue);
        
                
        Body  platform2 = new StaticBody(this,platformShape1 );
        platform2.setPosition(new Vec2(-14.5f,7f));
        platform2.setAngleDegrees(45);
        platform2.setFillColor(Color.blue);
        
        Body  platform3 = new StaticBody(this,platformShape1 );
        platform3.setPosition(new Vec2(-14.5f,-3f));
        platform3.setAngleDegrees(45);
        platform3.setFillColor(Color.blue);
        
        Body  platform4 = new StaticBody(this,platformShape1 );
        platform4.setPosition(new Vec2(14.5f,-3f));
        platform4.setAngleDegrees(-45);
        platform4.setFillColor(Color.blue);
                     
        Body platform5 = new StaticBody(this,platformShape2);
        platform5.setPosition(new Vec2(8.7f, 2.9f));
        platform5.setAngleDegrees(-45);
        platform5.setFillColor(Color.blue);
        Body platform6 = new StaticBody(this, platformShape2);
        platform6.setPosition(new Vec2(3.75f, -2.75f));
        platform6.setAngleDegrees(-45);
        platform6.setFillColor(Color.blue);
        
        // Create the necessary platforms for the structure of level 3
        
         portal = new Portal(this);
         portal.setPosition(new Vec2(0f,-8.5f));
         portal.addCollisionListener(new PortalPickup(getVillain()));
         
         //Create entrance potral object and add repective collision listeneder of Potral pickup
         // to the object
         exit = new Portal(this);
         exit.setPosition(new Vec2(16.5f,2f));
         exit.setAngleDegrees(39);
                          
         exit = new Portal(this);
         exit.setPosition(new Vec2(-16.5f,2f));
         exit.setAngleDegrees(-35);
         
         exit = new Portal(this);
         exit.setPosition(new Vec2(15f,10.5f));
         exit.setAngleDegrees(40);
         
         // Create 3 exit portals for level 3, these will not have a collision listener as they 
         // are only used as an exit from the entrance portal.
            
         
         for (int i = 0; i < 5; i++) {
            Body ball = new BallStatic(this);
            ball.setPosition(new Vec2(ballSpaceX , ballSpaceY));
            ballSpaceX = ballSpaceX + 3 ;
            ballSpaceY = ballSpaceY - 3;
             ball.addCollisionListener(new BallStaticPickup(getVillain(), villainCarnage));
        }
          for (int i = 0; i < 5; i++) {
            Body ball = new BallStatic(this);
            ball.setPosition(new Vec2(ballSpaceX2 , ballSpaceY2));
            ballSpaceX2 = ballSpaceX2 - 3 ;
            ballSpaceY2 = ballSpaceY2 - 3;
             ball.addCollisionListener(new BallStaticPickup(getVillain(), villainCarnage));
        }
          
          for (int i = 0; i < 3; i++) {
            Body ball = new BallStatic(this);
            ball.setPosition(new Vec2(ballSpaceX3 , ballSpaceY3));
            ballSpaceX3 = ballSpaceX3 - 3 ;
            ballSpaceY3 = ballSpaceY3 - 3;
             ball.addCollisionListener(new BallStaticPickup(getVillain(), villainCarnage));
        }
           // The above 3 for loops  Generates Static Balls spread across the level for the player for collect.
             //If the player collides with the ball, the BallStaticPickup 
            // class will be called to increment ball count and destory the reporting body
            // This is done with 3 for loops as the position of the balls are not in a continuing pattern
         
    }
    @Override
    public Vec2 startPosition() {
     return new Vec2(4, -10);
     // Set the start position of the villain Object 
    }
    @Override
public Vec2 speedPosition(){
        return new Vec2(0,0);
    }
    @Override
    public Vec2 flamePosition() {
     return new Vec2(-16, 11);
     // set the position of the BlueFlame object in level 3
    }
}
    

