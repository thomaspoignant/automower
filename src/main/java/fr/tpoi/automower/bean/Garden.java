package fr.tpoi.automower.bean;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class Garden {

  /**
   * maxX is the max X value in the grid
   */
  private int maxX;
  /**
   * maxY is the max Y value in the grid
   */
  private int maxY;
  /**
   * automowers is the list of automower in the garden
   */
  private Map<Automower, Movement> automowers;

  /**
   * This method move all the automower on the grid
   */
  public void moveAutomowers() {
    automowers.forEach(
        (automower, movement) -> {
          movement.getMovementLine().chars()
              .forEachOrdered(i -> updatePosition(automower, (char) i));
        });
  }

  private void updatePosition(final Automower automower, final char action) {
    Action currentAction = Action.valueOf(String.valueOf(action));
    switch (currentAction) {
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

