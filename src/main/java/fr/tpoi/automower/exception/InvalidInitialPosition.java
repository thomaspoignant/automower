package fr.tpoi.automower.exception;

import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.bean.Automower;

public class InvalidInitialPosition extends Exception
{
  public InvalidInitialPosition(final Automower automower, final Garden garden)
  {
    super("Invalid initial position, automower is not in the garden [x:"+ automower.getX()
              +",maxX:"+garden.getMaxX()
              +",y:"+ automower.getY()
              +",maxY:"+garden.getMaxY()
              +"]");
  }
}
