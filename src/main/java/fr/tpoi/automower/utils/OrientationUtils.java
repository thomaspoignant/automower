package fr.tpoi.automower.utils;

import fr.tpoi.automower.bean.Orientation;
import java.util.EnumMap;
import java.util.Map;

public class OrientationUtils {

  public static Orientation turnLeft(Orientation orientation) {
    Map<Orientation, Orientation> onLeft = new EnumMap<>(Orientation.class);
    onLeft.put(Orientation.E, Orientation.N);
    onLeft.put(Orientation.N, Orientation.W);
    onLeft.put(Orientation.W, Orientation.S);
    onLeft.put(Orientation.S, Orientation.E);
    return onLeft.get(orientation);
  }

  public static Orientation turnRight(Orientation orientation) {
    Map<Orientation, Orientation> onRight = new EnumMap<>(Orientation.class);
    onRight.put(Orientation.E, Orientation.S);
    onRight.put(Orientation.N, Orientation.E);
    onRight.put(Orientation.W, Orientation.N);
    onRight.put(Orientation.S, Orientation.W);
    return onRight.get(orientation);
  }
}
