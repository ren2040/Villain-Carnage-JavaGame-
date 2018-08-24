package villaincarnage;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 * This class will create the static ball object which is used in level 3 , the character must pick up these
 * balls in order to proceed to level 4 of the game
 * @author Family
 */
public class BallStatic extends StaticBody {
    private static final Shape shape = new CircleShape(0.8f);
    
    public BallStatic(World world) {
        super(world, shape);
        setFillColor(Color.magenta);
        setLineColor(Color.ORANGE);
        
    }
    // Creates ball shape to be used , sets the appropriate fill color and 
    // line color. The ball will be a static body as it is required for it to be
    // levitating in the air.
}
