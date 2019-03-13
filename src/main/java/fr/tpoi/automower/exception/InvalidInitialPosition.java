package fr.tpoi.automower.exception;

import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.bean.Mower;

public class InvalidInitialPosition extends Exception
{
  public InvalidInitialPosition(final Mower mower, final Garden garden)
  {
    super("Invalid initial position, mower is not in the garden [x:"+mower.getX()
              +",maxX:"+garden.getMaxX()
              +",y:"+mower.getY()
              +",maxY:"+garden.getMaxY()
              +"]");
  }
}
