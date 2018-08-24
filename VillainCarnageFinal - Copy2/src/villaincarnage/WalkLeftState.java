package villaincarnage;

import fsm.FSMState;

/**
 *
 * @author Family
 */
public class WalkLeftState extends FSMState<AIBall> {

    protected void update() {
        AIBall AiBall = getContext();
        if (AiBall.inRangeRight()) {
            gotoState(new WalkRightState());
        } else if (!AiBall.inRange()) {
            gotoState(new StandStillState());
        } else {
            AiBall.setAngularVelocity(2);
        }
    }

    protected void enter() {
        AIBall AiBall = getContext();
        AiBall.setAngularVelocity(1);
    }
    
    protected void exit() {}
}
