package villaincarnage;
import city.cs.engine.*;

public class FlamePickup implements CollisionListener {
    private Villain villain;
    private VillainCarnage villainCarnage;
    
    public FlamePickup(Villain villain, VillainCarnage villainCarnage  ) {
        this.villain = villain;
        this.villainCarnage = villainCarnage;  
    }
     
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == villain) {
            if (villainCarnage.getLevel() == 1){  
            if (villain.getBallCount() == 9){
            e.getReportingBody().destroy();
             System.out.println("Well done! You have completed level 1!");
             villainCarnage.goNextLevel();
             // If current level is 1 then ball count must equal to 9 before the villain character can
             // collect the blueFlame and proceed to the next level. If successful  the respective message will
             // be output and player proceeds to next level.
             
            }else
                System.out.println("You must collect all the Energy balls first before proceeding!");
            // Otherwise the player will get the message that they have not yet colleceted all the balls yet.
            
            }else if (villainCarnage.getLevel() == 2){
                 if (villain.getBallCount() == 3){
                     e.getReportingBody().destroy();
             System.out.println("Well done! You have completed level 2!");
             villainCarnage.goNextLevel();
             // If the current level is 2 then the ball count must be 3 before proceeding to the next level
                 
                 }else  
                     
                 if (villain.getBallCount() == 12){
                     e.getReportingBody().destroy();
             System.out.println("Well done! You have completed level 3!");
             villainCarnage.goNextLevel();
             // Finally if current level is 3 then the ball count must be 12 before the character can proceed to the next Level
             
            }else
                      System.out.println("You must collect all the Energy balls first before proceeding!");
            }
             // Else the appropriate message will be generated to tell the player that they must collecet all the balls
             // before proceeding.
            }
        }
    }
   
    
  