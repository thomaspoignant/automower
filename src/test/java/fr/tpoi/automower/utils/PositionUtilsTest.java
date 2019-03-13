package fr.tpoi.automower.utils;

import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.bean.Mower;
import fr.tpoi.automower.exception.InvalidInitialPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionUtilsTest
{
  private Garden garden;
  
  @BeforeEach
  void init()
  {
    garden = new Garden(5,5);
  }
  
  @Test
  void validPosition() throws Exception
  {
    Mower mower = Mower.builder().x(1).y(1).build();
    assertThatCode(()-> PositionUtils.isPositionValid(garden,mower))
      .doesNotThrowAnyException();
  }
  
  @Test
  void invalidPosition_negativeX() throws Exception
  {
    Mower mower = Mower.builder().x(-1).y(1).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden,mower))
      .isInstanceOf(InvalidInitialPosition.class)
      .hasMessage("Invalid initial position, mower is not in the garden [x:-1,maxX:5,y:1,maxY:5]");
  }
  
  @Test
  void invalidPosition_negativeY() throws Exception
  {
    Mower mower = Mower.builder().x(1).y(-1).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden,mower))
        .isInstanceOf(InvalidInitialPosition.class)
        .hasMessage("Invalid initial position, mower is not in the garden [x:1,maxX:5,y:-1,maxY:5]");
  }
  
  @Test
  void invalidPosition_toobigY() throws Exception
  {
    Mower mower = Mower.builder().x(1).y(6).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden,mower))
        .isInstanceOf(InvalidInitialPosition.class)
        .hasMessage("Invalid initial position, mower is not in the garden [x:1,maxX:5,y:6,maxY:5]");
  }
  
  @Test
  void invalidPosition_toobigX() throws Exception
  {
    Mower mower = Mower.builder().x(6).y(1).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden,mower))
        .isInstanceOf(InvalidInitialPosition.class)
        .hasMessage("Invalid initial position, mower is not in the garden [x:6,maxX:5,y:1,maxY:5]");
  }
}