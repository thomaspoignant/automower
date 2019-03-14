package fr.tpoi.automower.bean;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AutomowerTest
{
  @Test
  public void turnLeftTest()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.N).build();
    assert(automower.getOrientation()).equals(Orientation.N);
    automower.turnLeft();
    assert(automower.getOrientation()).equals(Orientation.W);
  }
  
  @Test
  public void turnRightTest()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.N).build();
    assert(automower.getOrientation()).equals(Orientation.N);
    automower.turnRight();
    assert(automower.getOrientation()).equals(Orientation.E);
  }
  
  @Test
  public void moveToNorth_insideGarden()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.N).build();
    automower.moveForward(10, 10);
    assertThat(automower.getY()).isEqualTo(6);
    assertThat(automower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToSouth_insideGarden()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.S).build();
    automower.moveForward(10, 10);
    assertThat(automower.getY()).isEqualTo(4);
    assertThat(automower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToEast_insideGarden()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.E).build();
    automower.moveForward(10, 10);
    assertThat(automower.getY()).isEqualTo(5);
    assertThat(automower.getX()).isEqualTo(6);
  }
  
  @Test
  public void moveToWest_insideGarden()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.W).build();
    automower.moveForward(10, 10);
    assertThat(automower.getY()).isEqualTo(5);
    assertThat(automower.getX()).isEqualTo(4);
  }
  
  @Test
  public void moveToEast_inBorder()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.E).build();
    automower.moveForward(5, 5);
    assertThat(automower.getY()).isEqualTo(5);
    assertThat(automower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToWest_inBorder()
  {
    Automower automower= Automower.builder().x(0).y(5).orientation(Orientation.W).build();
    automower.moveForward(5, 5);
    assertThat(automower.getY()).isEqualTo(5);
    assertThat(automower.getX()).isEqualTo(0);
  }
  
  @Test
  public void moveToSouth_inBorder()
  {
    Automower automower= Automower.builder().x(5).y(0).orientation(Orientation.S).build();
    automower.moveForward(5, 5);
    assertThat(automower.getY()).isEqualTo(0);
    assertThat(automower.getX()).isEqualTo(5);
  }
  
  @Test
  public void moveToNorth_inBorder()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.N).build();
    automower.moveForward(5, 5);
    assertThat(automower.getY()).isEqualTo(5);
    assertThat(automower.getX()).isEqualTo(5);
  }
  
  @Test
  public void toStringFormat()
  {
    Automower automower= Automower.builder().x(5).y(5).orientation(Orientation.N).build();
    assertThat(automower.toString()).isEqualTo("5 5 N");
  }
}