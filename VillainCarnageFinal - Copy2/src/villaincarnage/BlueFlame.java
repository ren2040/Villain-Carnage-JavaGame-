package villaincarnage;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BlueFlame extends StaticBody {
     
     private static final Shape flameShape = new PolygonShape(
       0.02f,1.5f, -0.58f,0.82f, -0.84f,-0.32f, -0.63f,-1.22f, -0.1f,-1.44f, 0.37f,-1.44f, 0.91f,-0.24f, 0.16f,1.29f);
    
     private static final BodyImage image =
         new BodyImage("data/blueflame.png", 3f);
     public BlueFlame(World world) {
         super(world, flameShape);
         addImage(image);
     }
     // Creates the BlueFlame PolygonShape to be used. This will be present in each level
     // as it will be the final item for the player to collect to proceed to the next level after
     // all the balls have been collected.
         
     }
 
