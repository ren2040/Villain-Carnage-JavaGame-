package villaincarnage;

import city.cs.engine.*;

/**
 * This class will implement the collision listener for the AIBall class, If the AIBall class
 * interacts with the lava object then the reporting lava object will be destroyed and the incrementLives
 * method from villain class will be called to increase the lives of the player
 * @author Family
 */
public class AIBallPickup implements CollisionListener {
     
    private Lava lava;
    private Villain villain;
    
     
     
    
    public AIBallPickup(Lava lava, Villain villain  ) {
        this.lava = lava;
        this.villain = villain;  
    }
     

    
     

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == lava) {
              
             
           e.getOtherBody().destroy();
             
            villain.incrementLives();
             System.out.println("You have killed the lava and gained more life!" + villain.geLives());
             
              
             
             
            }
        // implements collision listener for AIBall pickup , whenever the lava object collides with AIBall object the
        //increment lives method in villain class will be called and the reporting body for the lava will be destroyed.
        }
       
    }
    