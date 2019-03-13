package fr.tpoi.automower.utils;

import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.bean.Mower;
import fr.tpoi.automower.exception.InvalidInitialPosition;

public class PositionUtils
{
  
  public static void isPositionValid(final Garden garden, final Mower mower) throws InvalidInitialPosition
  {
    if(mower.getY()<0 || mower.getY()>garden.getMaxY() || mower.getX()<0 || mower.getX()>garden.getMaxX()){
      throw new InvalidInitialPosition(mower,garden);
    }
  }
}
