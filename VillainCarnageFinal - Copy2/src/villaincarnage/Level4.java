/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villaincarnage;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import java.awt.Color;
import org.jbox2d.common.Vec2;

 
public class Level4 extends GameLevel {
  
    private GameBoss gameBoss;
    private BlackBall blackBall;
    private SpikeStatic spike;
    private int spikeSpace = 11;
    private int ballSpace = 8;
    
   @Override
    public void populate(VillainCarnage villainCarnage ) {
        super.populate(villainCarnage );
        
         gameBoss = new GameBoss(this);
         gameBoss.setPosition(new Vec2(-10f,-4f));
         
         // Creates the game boss object for level 4  
         
          for ( int i=0;i<6;i++){
             blackBall = new BlackBall(this);
             blackBall.setPosition(new Vec2(ballSpace, 9f));
             ballSpace = ballSpace - 6;
             blackBall.addCollisionListener(new BallPickup(getVillain(), villainCarnage));
          }
          // Generate 6 black ball objects spread across level 4 which will need to be collected to 
          // Complete the level. Each black ball will have the BallPickup collision listener added to it.
              
           for ( int i=0;i<6;i++){
             spike = new SpikeStatic(this);
             spike.setPosition(new Vec2(spikeSpace, 7f));
             spikeSpace = spikeSpace - 6;
              spike.addCollisionListener(new SpikePickup(getVillain()));
                
         }
           // Generate 6 spikes places in between the black ball object which the player is to avoid.
           // If the player collides with the spikes then the SpikePickup collision Listener will be called and
           // Player life will be decremented.
                 Shape platformShape1 = new BoxShape(1f,0.25f);
                 
        Body  platform2 = new StaticBody(this,platformShape1 );
        platform2.setPosition(new Vec2(14f,7f));
                platform2.setFillColor(Color.blue);   
      
                Body  platform4 = new StaticBody(this,platformShape1 );
        platform4.setPosition(new Vec2(8f,7f));
                platform4.setFillColor(Color.blue);
                        
                        Body  platform6 = new StaticBody(this,platformShape1 );
        platform6.setPosition(new Vec2(2f,7f));
                platform6.setFillColor(Color.blue);
                
                Body  platform8 = new StaticBody(this,platformShape1 );
        platform8.setPosition(new Vec2(-4f,7f));
                platform8.setFillColor(Color.blue);
                
                Body  platform10 = new StaticBody(this,platformShape1 );
        platform10.setPosition(new Vec2(-10f,7f));
                platform10.setFillColor(Color.blue);
                
                Body  platform12 = new StaticBody(this,platformShape1 );
        platform12.setPosition(new Vec2(-16f,7f));
                platform12.setFillColor(Color.blue);
        
        
         }
    // Creates the necessary platforms needed for the structure of level 4
         
    
    @Override
    public Vec2 startPosition() {
      return new Vec2(13.5f, 10f);
      // Set the start position of the character
    }
     @Override
public Vec2 speedPosition(){
        return new Vec2(0,0);
    }

    @Override
    public Vec2 flamePosition() {
      return new Vec2(-200, 10);
      // Set the position of BlueFlame object ( if present ) in level 4
    }
 
    
}  
