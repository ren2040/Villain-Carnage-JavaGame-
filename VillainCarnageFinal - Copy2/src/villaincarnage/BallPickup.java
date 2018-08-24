package villaincarnage;

import city.cs.engine.*;

/**
 * Collision listener that allows the villain to pickup the balls and increase the ball count
 * by calling the incrementBallCount method in the villain class
 */
public class BallPickup implements CollisionListener {
    
    private  Villain  villain;
    private int ballCount =0;
    private VillainCarnage villainCarnage;
    
    public BallPickup( Villain villain, VillainCarnage villainCarnage) {
        this.villain = villain;
        this.villainCarnage = villainCarnage;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == villain) {
         villain.setBallCount();
         villain.setBoss();
                    e.getReportingBody().destroy();
                       if (villainCarnage.getLevel() == 4){
                            if (villain.getBoss() == 0){
                               System.out.println("Well done you killed the boss!");
                               System.exit(0);
                         }        
                      }
                  }
              }
    // Overrides collide method to detect collision between Ball and villain, 
    // If collision has occured then the reporting ball body will be destroyed
    // and the getBoss class in villain will be called to decrement boss's life points
    // If boss life points has reached 0 then the level would be completed.
    
     
    
}