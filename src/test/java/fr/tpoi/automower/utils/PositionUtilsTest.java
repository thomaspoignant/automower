package fr.tpoi.automower.utils;

import fr.tpoi.automower.bean.Automower;
import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.exception.InvalidInitialPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class PositionUtilsTest {

  private Garden garden;

  @BeforeEach
  void init() {
    garden = Garden.builder().maxY(5).maxX(5).build();
  }

  @Test
  void validPosition() throws Exception {
    Automower automower = Automower.builder().x(1).y(1).build();
    assertThatCode(() -> PositionUtils.isPositionValid(garden, automower))
        .doesNotThrowAnyException();
  }

  @Test
  void invalidPosition_negativeX() throws Exception {
    Automower automower = Automower.builder().x(-1).y(1).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden, automower))
        .isInstanceOf(InvalidInitialPosition.class)
        .hasMessage(
            "Invalid initial position, automower is not in the garden [x:-1,maxX:5,y:1,maxY:5]");
  }

  @Test
  void invalidPosition_negativeY() throws Exception {
    Automower automower = Automower.builder().x(1).y(-1).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden, automower))
        .isInstanceOf(InvalidInitialPosition.class)
        .hasMessage(
            "Invalid initial position, automower is not in the garden [x:1,maxX:5,y:-1,maxY:5]");
  }

  @Test
  void invalidPosition_toobigY() throws Exception {
    Automower automower = Automower.builder().x(1).y(6).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden, automower))
        .isInstanceOf(InvalidInitialPosition.class)
        .hasMessage(
            "Invalid initial position, automower is not in the garden [x:1,maxX:5,y:6,maxY:5]");
  }

  @Test
  void invalidPosition_toobigX() throws Exception {
    Automower automower = Automower.builder().x(6).y(1).build();
    assertThatThrownBy(() -> PositionUtils.isPositionValid(garden, automower))
        .isInstanceOf(InvalidInitialPosition.class)
        .hasMessage(
            "Invalid initial position, automower is not in the garden [x:6,maxX:5,y:1,maxY:5]");
  }
}