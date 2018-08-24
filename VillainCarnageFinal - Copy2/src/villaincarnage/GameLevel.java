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
import city.cs.engine.World;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Family
 */
public abstract class  GameLevel extends World {
    public Villain villain;
    public Controller controller;
    public Lava lava;
    public Lava lava2;
    
    public Villain getVillain(){
        return villain;
        
           }
    
    public Lava getLava(){
        return lava;
    }
    public Lava getLava2(){
        return lava2;
    }
    
    public void populate(VillainCarnage villainCarnage ) {
        villain = new Villain(this);
        villain.setPosition(startPosition());
           
        
        BlueFlame blueFlame = new BlueFlame(this);
        blueFlame.setPosition(flamePosition());
      blueFlame.addCollisionListener(new FlamePickup(villain,villainCarnage));
      
   
      
      Shape wallShape = new BoxShape(10f, 23);
        Body wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-28.5f, 12.5f));
        wall1.setFillColor(Color.orange);
        Body wall2 = new StaticBody(this, wallShape );
       wall2.setPosition(new Vec2(28.5f, 12.5f));
        wall2.setFillColor(Color.orange);
        Shape wallShape2 = new BoxShape(23f, 0.5f);
         
        Shape shapeGround = new BoxShape(40,10f);
        Body ground = new StaticBody(this,shapeGround );
        ground.setPosition(new Vec2(0,-20.55f));
        ground.setFillColor(Color.blue);
    }
    // Populates each level that extends GameLevel class with appropriate ground shape,
    // wall shape and BlueFlame and villain objects.   
    
      
    public abstract Vec2 startPosition();
    // Absrract method to be implemented in each individual level that extends Game level to 
    // set the Start position of the villain object.
    
    public abstract Vec2 flamePosition();
      // Absrract method to be implemented in each individual level that extends Game level to 
    // set the Start position of the BlueFlame object.
    public abstract Vec2 speedPosition();
    
     
    
}
