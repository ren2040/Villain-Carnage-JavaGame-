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
public class Life extends StaticBody {
    private static final Shape heartShape = new PolygonShape(-0.98f,1.46f, -1.69f,0.65f, -0.08f,
            -1.85f, 1.88f,0.54f, 1.01f,1.51f);
         
    private static final BodyImage image =
        new BodyImage("data/heart.png", 3f);
    
    public Life(World world) {
        super(world, heartShape);
        addImage(image);
    }
    // Create the static body polygon shape for life. Will use it's respective BodyImage from the 
    // data directory 
}
 
