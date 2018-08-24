package villaincarnage;

 

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

 
public class Lava extends Walker {
  
    private static final Shape villainShape = new PolygonShape(-2.96f,0.12f, -0.87f,1.97f, 
            2.96f,0.81f, 2.97f,-1.32f, 0.1f,-1.85f, -1.91f,-2.02f);
         
    private static final BodyImage image =
        new BodyImage("data/lavamonster.png", 4f);
    public Lava(World world) {
        super(world, villainShape);
        addImage(image);
       
    }
     
    // Create the lava monster object to be used in level 1 and level 2
    
}
// 