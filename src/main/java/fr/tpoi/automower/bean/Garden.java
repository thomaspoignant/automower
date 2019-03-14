package fr.tpoi.automower.bean;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class Garden
{
  /** maxX is the max X value in the grid*/
  private int maxX;
  /** maxY is the max Y value in the grid*/
  private int maxY;
  private Map<Automower, Movement> mowers;

  /**
   * This method move all the automower on the grid
   */
  public void moveAutomowers()
  {
    mowers.forEach(
        (mower, movement)-> moveCurrentAutomower(mower, movement.getMovementLine()));
  }
  
  private void moveCurrentAutomower(final Automower automower, final String movementLine)
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

