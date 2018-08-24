package villaincarnage;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class BallStaticPickup implements CollisionListener {
    
    private  Villain  villain;
    private VillainCarnage villainCarnage;
    private int ballCount =0 ;

    /**
     * Implements the collision listener for BallStatic object, decreasing the boss's health through the 
     * setBossLife method in the villain class each time the villain object interacts with the ball object
     * @param villain
     * @param villainCarnage
     */
    public BallStaticPickup( Villain villain, VillainCarnage villainCarnage) {
        this.villain = villain;
        this.villainCarnage = villainCarnage;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == villain) {
            if (villain.getBallCount() ==11){
                 villainCarnage.goNextLevel();
            
            }else   villain.setBallCount();{
            e.getReportingBody().destroy();
        }
        }
        // Overrides the collide method from CollisionListener class to detect collision 
        // between reporting ball body and villain, If collision occurs then ballCount variable in villain 
        // class will be incremented through the .setBallCount method. If ball cont reachess 11 then 
        // player will proceeD to the next level.
    }
    
}