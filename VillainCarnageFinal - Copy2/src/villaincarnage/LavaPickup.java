package villaincarnage;

import city.cs.engine.*;

 
public class LavaPickup implements CollisionListener {
    private Villain villain;
    
    public LavaPickup(Villain villain  ) {
        this.villain = villain;
          
    }
    
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == villain) {
             villain.setlavaTouched();
            e.getReportingBody().destroy();
               
        }
        // If lava object collides with villain character the setLavaTouched method will be called from the villain
        // class and lava object will be destroyed.
       
    }
    
}