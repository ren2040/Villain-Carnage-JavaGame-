package villaincarnage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

 
public class EnergyBall extends DynamicBody {
    private static final Shape shape = new CircleShape(0.8f);
    
    public EnergyBall(World world) {
        super(world, shape);
        setFillColor(Color.orange);
        setLineColor(Color.red);
        
    }
    // Create the energy ball which is used in levels 1 and 2 
    // Sets the fill color and line color of the ball shape.
}