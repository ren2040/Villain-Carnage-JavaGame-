package villaincarnage;

import city.cs.engine.*;

 
public class SpikePickup implements CollisionListener {
     
    private Villain villain;
    
     
     
    
    public SpikePickup(Villain villain  ) {
        this.villain = villain;
          
    }
     

    
     

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == villain) {
              
             
            e.getReportingBody().destroy();
            villain.DecrementLives();
             System.out.println("Avoid the Spike traps! Lives left : " + villain.geLives());
              
             
             
            }
        // implements collision listener for spike pickup , whenever the villain object collides with spike object the
        // decrement lives method in villain class will be called and the reporting body for the spike will be destroyed.
        }
       
    }
    