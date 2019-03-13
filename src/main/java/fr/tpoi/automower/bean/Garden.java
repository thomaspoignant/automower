package fr.tpoi.automower.bean;

import fr.tpoi.automower.exception.InvalidInitialPosition;
import java.util.ArrayList;
import java.util.List;
import fr.tpoi.automower.utils.PositionUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Garden
{
  private int maxX;
  private int maxY;
  
  public void moveMower(final Mower mower, final String movementLine)
  {
    movementLine.chars()
        .forEachOrdered(i -> updatePosition(mower,(char)i));
  }

  private void updatePosition(final Mower mower, final char action)
  {
    Action currentAction = Action.valueOf(String.valueOf(action));
    switch(currentAction){
      case L:
        mower.turnLeft();
        break;
      case R:
        mower.turnRight();
        break;
      case F:
        mower.move(maxX,maxY);
        break;
      default:
        //exception
        break;
    }
  }
}

