package fr.tpoi.automower.utils;

import fr.tpoi.automower.bean.Automower;
import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.exception.InvalidInitialPosition;

public class PositionUtils
{
  
  public static void isPositionValid(final Garden garden, final Automower automower) throws InvalidInitialPosition
  {
    if(automower.getY()<0 || automower.getY()>garden.getMaxY() || automower.getX()<0 || automower.getX()>garden.getMaxX()){
      throw new InvalidInitialPosition(automower, garden);
    }
  }
}
