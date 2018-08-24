package villaincarnage;

import fsm.FSMState;

public class WalkRightState extends FSMState<AIBall> {

    protected void update() {
        AIBall AiBall = getContext();
        if (AiBall.inRangeLeft()) {
            gotoState(new WalkLeftState());
        } else if (!AiBall.inRange()) {
            gotoState(new StandStillState());
        } else {
            AiBall.setAngularVelocity(-2);
        }
    }

    protected void enter() {
        AIBall AiBall = getContext();
        AiBall.setAngularVelocity(-1);
    }
    
    protected void exit() {}
}
