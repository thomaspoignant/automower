package fr.tpoi.automower.bean;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GardenTest
{
  @Test
  public void firstExample()
  {
    Garden garden = new Garden(5,5);
    Mower mower = Mower.builder().x(1).y(2).orientation(Orientation.N).build();
    garden.moveMower(mower,"LFLFLFLFF");
    assertThat(mower.getX()).isEqualTo(1);
    assertThat(mower.getY()).isEqualTo(3);
    assertThat(mower.getOrientation()).isEqualTo(Orientation.N);
  }
  
  @Test
  public void secondExample()
  {
    Garden garden = new Garden(5,5);
    Mower mower = Mower.builder().x(3).y(3).orientation(Orientation.E).build();
    garden.moveMower(mower,"FFRFFRFRRF");
    assertThat(mower.getX()).isEqualTo(5);
    assertThat(mower.getY()).isEqualTo(1);
    assertThat(mower.getOrientation()).isEqualTo(Orientation.E);
  }
}