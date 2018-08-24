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
public class Portal extends StaticBody {
    private static final Shape portalShape = new PolygonShape(-1.43f,2.44f, -1.99f,-2.11f, 1.94f,-2.07f, 1.19f,2.45f);
         
    private static final BodyImage image =
        new BodyImage("data/portal.gif", 5f);
    
    
    public Portal(World world) {
        super(world, portalShape);
        addImage(image);
    }
    // Create the portal static body polygon shape for level 3, It's respective bodyimage will be
    // used from the data directory
}
//-0.84f,1.25f, -1.23f,-1.29f, 1.08f,-1.29f, 0.82f,1.3f, -0.08f,1.46f