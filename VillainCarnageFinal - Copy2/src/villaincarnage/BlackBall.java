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
public class BlackBall extends StaticBody{
      private static final Shape flameShape = new PolygonShape(
      -0.044f,0.472f, 0.392f,0.288f, 0.44f,-0.304f, -0.196f,-0.468f, -0.5f,0.036f, -0.368f,0.356f);
    
     private static final BodyImage image =
         new BodyImage("data/blackball.gif", 2f);

    /**
     * Creates the ball object used in level 4 of the game which the player msut pick up in order to kill the final boss and finish the game
     * each time the villain object interacts with the BlackBall object the setBossLife method in villain class will be 
     * called to decrement the lives
     * @param world
     */
    public BlackBall(World world) {
         super(world, flameShape);
         addImage(image);
     }
     // Creates the Blackball body which is used in the final level of the game. Similar to static ball
     // but uses a bodyImage from the data directory.
       
}
 