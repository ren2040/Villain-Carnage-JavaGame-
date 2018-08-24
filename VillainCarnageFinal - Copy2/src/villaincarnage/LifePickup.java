/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villaincarnage;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author Family
 */
public class LifePickup implements CollisionListener{
    private Villain villain;
   
    
    public LifePickup(Villain villain  ) {
        this.villain = villain;
        
    }
    
     @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == villain) {
              villain.incrementLives();;
            System.out.println("Life pickup! new lives : " + villain.getLives());
            e.getReportingBody().destroy();
                      }
        }
    // Implements the life pikcup collision listener, If collision occurs between the life object and villain
    // then lives will be incremented by calling the incrementLives method from villain class.
    // appropriate output message will also be generated
}
