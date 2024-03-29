package fr.tpoi.automower.bean;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GardenTest {

  @Test
  public void firstExample() {
    Map<Automower, Movement> mowerMovement = new HashMap<>();
    Automower automower = Automower.builder().x(1).y(2).orientation(Orientation.N).build();
    mowerMovement.put(automower, Movement.builder().movementLine("LFLFLFLFF").build());

    Garden garden = Garden.builder().maxX(5).maxY(5).automowers(mowerMovement).build();
    garden.moveAutomowers();

    assertThat(automower.getX()).isEqualTo(1);
    assertThat(automower.getY()).isEqualTo(3);
    assertThat(automower.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  public void secondExample() {
    Map<Automower, Movement> mowerMovement = new HashMap<>();
    Automower automower = Automower.builder().x(3).y(3).orientation(Orientation.E).build();
    mowerMovement.put(automower, Movement.builder().movementLine("FFRFFRFRRF").build());

    Garden garden = Garden.builder().maxX(5).maxY(5).automowers(mowerMovement).build();
    garden.moveAutomowers();

    assertThat(automower.getX()).isEqualTo(5);
    assertThat(automower.getY()).isEqualTo(1);
    assertThat(automower.getOrientation()).isEqualTo(Orientation.E);
  }

  @Test
  public void emptyMover() {
    Map<Automower, Movement> mowerMovement = new HashMap<>();
    Automower automower = Automower.builder().x(3).y(3).orientation(Orientation.E).build();
    mowerMovement.put(automower, Movement.builder().movementLine("").build());

    Garden garden = Garden.builder().maxX(5).maxY(5).automowers(mowerMovement).build();
    garden.moveAutomowers();

    assertThat(automower.getX()).isEqualTo(3);
    assertThat(automower.getY()).isEqualTo(3);
    assertThat(automower.getOrientation()).isEqualTo(Orientation.E);
  }

  @Test
  public void moveTillWall() {
    Map<Automower, Movement> mowerMovement = new HashMap<>();
    Automower automower = Automower.builder().x(0).y(0).orientation(Orientation.N).build();
    mowerMovement.put(automower, Movement.builder().movementLine("FFFFFFFRFFFF").build());

    Garden garden = Garden.builder().maxX(3).maxY(3).automowers(mowerMovement).build();
    garden.moveAutomowers();

    assertThat(automower.getX()).isEqualTo(3);
    assertThat(automower.getY()).isEqualTo(3);
    assertThat(automower.getOrientation()).isEqualTo(Orientation.E);
  }
}