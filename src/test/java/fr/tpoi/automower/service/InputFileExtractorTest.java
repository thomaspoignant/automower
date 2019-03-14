package fr.tpoi.automower.service;

import fr.tpoi.automower.exception.InvalidInputFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class InputFileExtractorTest
{
  @Test
  void extractInputFile_invalid_maxY()
  {
    assertThatCode(()->InputFileExtractor.extractInputFile("input_invalid_limit"))
        .isInstanceOf(InvalidInputFile.class);
  }
  
  @Test
  void extractInputFile_invalid_move_2_letter()
  {
    assertThatCode(()->InputFileExtractor.extractInputFile("input_invalid_mower_move_2_letter"))
        .isInstanceOf(InvalidInputFile.class);
  }
  
  @Test
  void extractInputFile_invalid_mower_letter_position()
  {
    assertThatCode(()->InputFileExtractor.extractInputFile("input_invalid_mower_letter_position"))
        .isInstanceOf(InvalidInputFile.class);
  }
  
  @Test
  void extractInputFile_valid() throws IOException, InvalidInputFile
  {
    InputFileExtractor input = InputFileExtractor.extractInputFile("input");
    assertThat(input.getMaxX()).isEqualTo(5);
    assertThat(input.getMaxY()).isEqualTo(5);
    assertThat(input.getAutomowerAndMove().size()).isEqualTo(2);
  }
}