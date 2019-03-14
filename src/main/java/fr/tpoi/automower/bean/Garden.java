package fr.tpoi.automower.bean;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class Garden
{
  private int maxX;
  private int maxY;
  private Map<Automower, Movement> mowers;
  
  public void moveMowers()
  {
    mowers.forEach(
        (mower, movement)-> moveCurrentMower(mower, movement.getMovementLine()));
  }
  
  private void moveCurrentMower(final Automower automower, final String movementLine)
  {
    movementLine.chars()
        .forEachOrdered(i -> updatePosition(automower, (char)i));
  }

  private void updatePosition(final Automower automower, final char action)
  {
    Action currentAction = Action.valueOf(String.valueOf(action));
    switch(currentAction){
      case L:
        automower.turnLeft();
        break;
      case R:
        automower.turnRight();
        break;
      case F:
        automower.moveForward(maxX, maxY);
        break;
    }
  }
}

