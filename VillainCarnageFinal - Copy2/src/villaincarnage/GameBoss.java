/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villaincarnage;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author Family
 */
public class GameBoss extends StaticBody{
    private int  bossHealth = 50;
    private static final Shape bossShape = new PolygonShape(
       0.95f,6.86f, 7.28f,5.89f, 13.88f,-5.66f, -14.07f,-6.21f, -4.18f,6.03f);
    
     private static final BodyImage image =
         new BodyImage("data/gameboss.gif", 14f);
     
     // Create the Game boss Polygon shape used in level 4 using the appropraite body image from the 
     // Data directory
     
     
     public GameBoss(World  world) {
         super(world, bossShape);
         addImage(image);
     }
     public void setBossHealth(){
         if (bossHealth > 5){
         bossHealth = bossHealth - 5;
         }
         // This method will be called from the villain class so that each time the villain
         // collides with a black ball the boss health wil reduce by 5
     }
         public int getBossHealth(){
             return bossHealth;
             // Returns remaining boss health
         }
                 
     }
       
   
  
