package fr.tpoi.automower.utils;

import fr.tpoi.automower.bean.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationUtilsTest {

  @Test
  void turnLeft() {
    assert (OrientationUtils.turnLeft(Orientation.N)).equals(Orientation.W);
    assert (OrientationUtils.turnLeft(Orientation.W)).equals(Orientation.S);
    assert (OrientationUtils.turnLeft(Orientation.S)).equals(Orientation.E);
    assert (OrientationUtils.turnLeft(Orientation.E)).equals(Orientation.N);
  }

  @Test
  void turnRight() {
    assert (OrientationUtils.turnRight(Orientation.N)).equals(Orientation.E);
    assert (OrientationUtils.turnRight(Orientation.W)).equals(Orientation.N);
    assert (OrientationUtils.turnRight(Orientation.S)).equals(Orientation.W);
    assert (OrientationUtils.turnRight(Orientation.E)).equals(Orientation.S);
  }
}