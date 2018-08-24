package villaincarnage;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;
 
 
public class Level1 extends GameLevel  {
   
    private Lava lava;
    private Lava lava2;
    private Spikes spike;
    private int steps =100;
   public SoundClip gameMusic;
    
    @Override
    public void populate(VillainCarnage villainCarnage ) {
        super.populate(villainCarnage );

      Shape platformShape1 = new BoxShape(0.25f,5f);
        Body  platform1 = new StaticBody(this,platformShape1 );
        platform1.setPosition(new Vec2(10f,-5.5f));
        platform1.setFillColor(Color.blue);
        Body platform3 = new StaticBody(this,platformShape1);
        platform3.setPosition(new Vec2(17.5f,7.5f));
        platform3.setFillColor(Color.blue);
        Shape platformShape2 = new BoxShape(5f,0.25f);
        Body  platform2 = new StaticBody(this,platformShape2 );
        platform2.setPosition(new Vec2(5f,-0.75f));
        platform2.setFillColor(Color.blue);
        Shape platformShape3 = new BoxShape(1.5f,0.25f);
         Body platform4 = new StaticBody(this,platformShape3);       
        platform4.setPosition(new Vec2(16.25f,2.25f));
        platform4.setFillColor(Color.blue);
        
        Body platform5 = new StaticBody(this,platformShape2);
        platform5.setPosition(new Vec2(0f,6f));
        platform5.setFillColor(Color.blue);
        
        Body platform6  = new StaticBody(this,platformShape2);
        platform6.setPosition(new Vec2(-10f,-5f));
        platform6.setFillColor(Color.blue);
      
        
        Body platform8 = new StaticBody(this,platformShape3);
        platform8.setPosition(new Vec2(-16.5f,0f));
        platform8.setFillColor(Color.blue);
        
          
        
        // Creates all the base platforms for level 1 
   
          for (int i = 0; i < 9; i++) {
            Body ball = new EnergyBall(this);
            ball.setPosition(new Vec2(i*4-16.5f, 10));
             ball.addCollisionListener(new BallPickup(getVillain(), villainCarnage));
             // Generates 9 balls evenly spread across the level for the player for collect.
             //If the player collides with the ball, the BallPickup 
            // class will be called to increment ball count and destory the reporting body
            
        }
         for ( int i=0;i<4;i++){
             spike = new Spikes(this);
             spike.setPosition(new Vec2(i*4 -10,10));
              spike.addCollisionListener(new SpikePickup(getVillain()));
              // Generates 4 spikes evenly spread across the level for the player to avoid.
             //If the player collides with the spikes, the SpikePickup
            // class will be called to decrement lives and destory the reporting body
                
         }      
         lava = new Lava(this);
         lava.setPosition(new Vec2(-10,-10));
         lava.addCollisionListener(new LavaPickup(getVillain()));
         lava2 = new Lava(this);
         lava2.setPosition(new Vec2(5,-10 ));
         lava2.addCollisionListener(new LavaPickup(getVillain()));
         // Create lava objects for the player to avoid, and its respective collision listener 
         // of LavaPickup will be implemented. If the player collides with the lava objects the respective 
         // collision Listener class of Lava pickup will be called.
         AIBall AiBall = new AIBall(villainCarnage);
            AiBall.setPosition(new Vec2(0, 0));
            AiBall.addCollisionListener(new AIBallPickup(lava,villain));
            AiBall.addCollisionListener(new AIBallPickup(lava2,villain));
            // Create AIBall object and add appropriate collision listener of AIBallPickup to the object
          
    }

    @Override
    public Vec2 startPosition() {
      return new Vec2(15, -10);
      // Set villain object starting position for level 1
    }
    public void stopMusic(){
        gameMusic.stop();
        // Method implemented to stop game music if currently being played
    }

    @Override
    public Vec2 flamePosition() {
      return new Vec2(-16, 10);
      // Set the flame position for level 1
    }
    @Override
    public Vec2 speedPosition(){
        return new Vec2(0,0);
    }

    public Lava getLava(){
        return lava;
    } 
    public Lava getLava2(){
        return lava2;
    }
    public Spikes getSpikes(){
        return spike;
    }
    
    
     
}
