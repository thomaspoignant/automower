package fr.tpoi.automower.bean;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MowerTest
{
  @Test
  public void turnLeftTest()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.N).build();
    assert(mower.getOrientation()).equals(Orientation.N);
    mower.turnLeft();
    assert(mower.getOrientation()).equals(Orientation.W);
  }
  
  @Test
  public void turnRightTest()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.N).build();
    assert(mower.getOrientation()).equals(Orientation.N);
    mower.turnRight();
    assert(mower.getOrientation()).equals(Orientation.E);
  }
  
  @Test
  public void moveToNorth_insideGarden()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.N).build();
    mower.move(10,10);
    assertThat(mower.getY()).isEqualTo(6);
    assertThat(mower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToSouth_insideGarden()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.S).build();
    mower.move(10,10);
    assertThat(mower.getY()).isEqualTo(4);
    assertThat(mower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToEast_insideGarden()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.E).build();
    mower.move(10,10);
    assertThat(mower.getY()).isEqualTo(5);
    assertThat(mower.getX()).isEqualTo(6);
  }
  
  @Test
  public void moveToWest_insideGarden()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.W).build();
    mower.move(10,10);
    assertThat(mower.getY()).isEqualTo(5);
    assertThat(mower.getX()).isEqualTo(4);
  }
  
  @Test
  public void moveToEast_inBorder()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.E).build();
    mower.move(5,5);
    assertThat(mower.getY()).isEqualTo(5);
    assertThat(mower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToWest_inBorder()
  {
    Mower mower = Mower.builder().x(0).y(5).orientation(Orientation.W).build();
    mower.move(5,5);
    assertThat(mower.getY()).isEqualTo(5);
    assertThat(mower.getX()).isEqualTo(0);
  }
  
  @Test
  public void moveToSouth_inBorder()
  {
    Mower mower = Mower.builder().x(5).y(0).orientation(Orientation.S).build();
    mower.move(5,5);
    assertThat(mower.getY()).isEqualTo(0);
    assertThat(mower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToNorth_inBorder()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.N).build();
    mower.move(5,5);
    assertThat(mower.getY()).isEqualTo(5);
    assertThat(mower.getX()).isEqualTo(5);
  }
  
  @Test
  public void toStringFormat()
  {
    Mower mower = Mower.builder().x(5).y(5).orientation(Orientation.N).build();
    assertThat(mower.toString()).isEqualTo("5 5 N");
  }
}