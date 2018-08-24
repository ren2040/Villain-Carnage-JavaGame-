package villaincarnage;

 

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

 
public class SpikeStatic extends StaticBody {
  
    private static final Shape spikeShape = new PolygonShape(-0.033f,0.493f, -0.364f,-0.388f, 
            -0.359f,-0.496f, 0.346f,-0.493f, 0.313f,-0.335f);
         
    private static final BodyImage image =
        new BodyImage("data/spike.png", 1f);
    public SpikeStatic(World world) {
        super(world, spikeShape);
        addImage(image);
       
    }
    // Create the static spike polygon shape using it's respective bodyImage from the data directory,
    // used in level 4
    
}