package fr.tpoi.automower.service;

import fr.tpoi.automower.exception.InvalidInputFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class InputFileExtractorTest {

  @Test
  void extractInputFile_invalid_maxY() {
    assertThatCode(() -> InputFileExtractor.extractInputFile("input_invalid_limit")).isInstanceOf(
        InvalidInputFile.class)
        .hasMessage(
            "The format of the input file is not correct, reason: Impossible to configure garden with non numeric elements");
  }

  @Test
  void extractInputFile_no_maxY() {
    assertThatCode(() -> InputFileExtractor.extractInputFile("input_invalid_no_maxY")).isInstanceOf(
        InvalidInputFile.class)
        .hasMessage(
            "The format of the input file is not correct, reason: Incorrect number of elements to configure the garden");
  }

  @Test
  void extractInputFile_invalid_move_2_letter() {
    assertThatCode(() -> InputFileExtractor.extractInputFile("input_invalid_mower_move_2_letter"))
        .isInstanceOf(
            InvalidInputFile.class)
        .hasMessage(
            "The format of the input file is not correct, reason: This orientation is not authorized");
  }

  @Test
  void extractInputFile_invalid_mower_letter_position() {
    assertThatCode(() -> InputFileExtractor.extractInputFile("input_invalid_mower_letter_position"))
        .isInstanceOf(
            InvalidInputFile.class)
        .hasMessage(
            "The format of the input file is not correct, reason: Impossible to configure automower with non numeric elements");
  }

  @Test
  void extractInputFile_valid() throws IOException, InvalidInputFile {
    InputFileExtractor input = InputFileExtractor.extractInputFile("input");
    assertThat(input.getMaxX()).isEqualTo(5);
    assertThat(input.getMaxY()).isEqualTo(5);
    assertThat(input.getAutomowerAndMove().size()).isEqualTo(2);
  }

  @Test
  void extractInputFile_invalid_move_missing_movement() {
    assertThatCode(
        () -> InputFileExtractor.extractInputFile("input_invalid_mower_missing_movement"))
        .isInstanceOf(
            InvalidInputFile.class)
        .hasMessage(
            "The format of the input file is not correct, reason: Missing movement line");
  }
}