package villaincarnage;

import fsm.FSM;
import city.cs.engine.*;

/**
 * @author Family
 */ 
public class AIBall extends Walker implements StepListener {
    
    private static final float radius = 1.0f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
        new BodyImage("data/fireball.png", 2*radius);

    /**
     * The range variable here will set the minimum range the character must be away from the AIBall for it to change it's state
     * 
     */
    public static final float RANGE = 5;
    
    private VillainCarnage villainCarnage;
    private FSM<AIBall> fsm;
    
    /**
     * Constructor for AIBall class here will initialise the fsm with the object and also put it in the StandStillState to begin with
     * 
     * @param villainCarnage
     */
    public AIBall(VillainCarnage villainCarnage) {
        super(villainCarnage.getWorld(), ballShape);
        this.villainCarnage = villainCarnage;
        addImage(ballImage);
        fsm = new FSM<AIBall>(this, new StandStillState());
        getWorld().addStepListener(this);
        // Creates the AI ball and assigns the new Shape created with the fsm class,
        // intilaising it with the "StandStillState" from the fsm, which will be changed
        // upon meeting certain conditions
    }
    
    /**
     * This class will check if the villain object is in range to the AIball towards it's left side
     * @return
     */
    public boolean inRangeLeft() {
        Body a = villainCarnage.getVillain();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
        // Checks if villain object is in range to the left of the AIBALL
    }
    
    /**
     *This class will check if the villain object is in range to the right of the AIBall object
     * @return
     */
    public boolean inRangeRight() {
        Body a = villainCarnage.getVillain();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;
        // Checks if villain object is in range to the right of the AIBALL
    }
    
    /**
     * If either inRangeLeft or inRangeRight returns true this class will return true 
     * @return
     */
    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
        // Checks if villain object is in range to the AIBall, it will return true
        // if either inRangeLeft or inRangeRight returns true
    }
    
    public void preStep(StepEvent e) {
        fsm.update();
    }
    
    public void postStep(StepEvent e) {}
}

