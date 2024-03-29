package fr.tpoi.automower.bean;

import fr.tpoi.automower.utils.OrientationUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
public class Automower {

  /**
   * Current x position on the grid
   */
  private int x = 0;
  /**
   * Current y position on the grid
   */
  private int y = 0;
  /**
   * Orientation of the automower
   */
  private Orientation orientation;

  public void turnLeft() {
    this.orientation = OrientationUtils.turnLeft(this.orientation);
  }

  public void turnRight() {
    this.orientation = OrientationUtils.turnRight(this.orientation);
  }

  public void moveForward(final int maxX, final int maxY) {
    switch (this.getOrientation()) {
      case N: {
        int nextY = y + 1;
        y = nextY > maxY ? maxY : nextY;
        break;
      }
      case S: {
        int nextY = y - 1;
        y = nextY < 0 ? 0 : nextY;
        break;
      }
      case E: {
        int nextX = x + 1;
        x = nextX > maxX ? maxX : nextX;
        break;
      }
      case W: {
        int nextX = x - 1;
        x = nextX < 0 ? 0 : nextX;
        break;
      }
    }
  }

  public String toString() {
    return x + " " + y + " " + orientation.name();
  }
}
