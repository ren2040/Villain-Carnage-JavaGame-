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
public class Level2 extends GameLevel {
    private SoundClip gameMusic;
    private Lava lava;
    private Spikes spike;
    private int ballSpace = 10;
    private int spikeSpace = 12;
    private Life life;
    private int lifeSpace = 12;
    @Override
    public void populate(VillainCarnage villainCarnage ) {
        super.populate(villainCarnage );
        
        
        

        Shape platformShape1 = new BoxShape(0.25f,5f);
        Body  platform1 = new StaticBody(this,platformShape1 );
        platform1.setPosition(new Vec2(10f,-5.5f));
        
        platform1.setFillColor(Color.blue);
        
        Body platform2 = new StaticBody(this, platformShape1);
        platform2.setPosition(new Vec2(5f,7.5f));
        platform2.setFillColor(Color.blue);
                  
        Body platform3 = new StaticBody(this, platformShape1);
        platform3.setPosition(new Vec2(0f,-5.5f));
        platform3.setFillColor(Color.blue);

        Body platform4 = new StaticBody(this, platformShape1);
        platform4.setPosition(new Vec2(-5f,7.5f));
        platform4.setFillColor(Color.blue);
   
        Body platform5 = new StaticBody(this, platformShape1);
        platform5.setPosition(new Vec2(-10f,-5.5f));
        platform5.setFillColor(Color.blue);
        
        Shape platformShape2 = new BoxShape(2f,0.25f);
        Body platform6 = new StaticBody(this,platformShape2);
        platform6.setPosition(new Vec2(-17,-3.5f));
        platform6.setFillColor(Color.blue);
        
        // Create the necessary platforms for the base structure of level 2 
        
        lava = new Lava(this);
         lava.setPosition(new Vec2(-12.5f,-10f));
         lava.addCollisionListener(new LavaPickup(getVillain()));
         
           AIBall AiBall = new AIBall(villainCarnage);
            AiBall.setPosition(new Vec2(-16,0));
            AiBall.addCollisionListener(new AIBallPickup(lava,villain));
             
         // Create AIBall object and add appropriate collision listener of AIBallPickup to the object
           for (int i = 0; i < 3; i++) {
            Body ball = new EnergyBall(this);
            ball.setPosition(new Vec2(ballSpace , 5));
            ballSpace = ballSpace -10;
             ball.addCollisionListener(new BallPickup(getVillain(),villainCarnage));
              // Generates 3 balls evenly spread across the level for the player for collect.
             //If the player collides with the ball, the BallPickup 
            // class will be called to increment ball count and destory the reporting body
        }
         for ( int i=0;i<8;i++){
             spike = new Spikes(this);
             spike.setPosition(new Vec2(spikeSpace, -10.5f));
             spikeSpace = spikeSpace - 3;
              spike.addCollisionListener(new SpikePickup(getVillain()));
         }
          // Generates 4 spikes evenly spread across the level for the player to avoid.
             //If the player collides with the spikes, the SpikePickup
            // class will be called to decrement lives and destory the reporting body
         for (int i=0;i<2;i++){
         life = new Life(this);
         life.setPosition(new Vec2(lifeSpace,8f));
         lifeSpace = lifeSpace - 12; 
         life.addCollisionListener(new LifePickup(getVillain()));
         }
         // Generate 2 life objects for level 2, If the player collides with the life object 
         // it's respective collision listener class of LifePickup will be called.
        
    }
    

    @Override
    public Vec2 startPosition() {
      return new Vec2(15, -10);
      // Set the starting position of the player
    }
    @Override
public Vec2 speedPosition(){
        return new Vec2(0,0);
    }
    @Override
    public Vec2 flamePosition() {
      return new Vec2(-16, 10);
      // Set the position of blueflame object for level 2
    }
    
}
