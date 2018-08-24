package villaincarnage;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

public class StandStillState extends FSMState<AIBall> {

    protected void update() {
        AIBall AiBall = getContext();
        if (AiBall.inRangeLeft()) {
            gotoState(new WalkLeftState());
        } else if (AiBall.inRangeRight()) {
            gotoState(new WalkRightState());
        }
    }

    protected void enter() {
        AIBall AiBall = getContext();
        AiBall.setAngularVelocity(0);
        AiBall.setLinearVelocity(new Vec2());
    }

    protected void exit() {
    }
}
