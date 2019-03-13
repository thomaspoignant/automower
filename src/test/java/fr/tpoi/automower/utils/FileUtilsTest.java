package fr.tpoi.automower.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest
{
  @Test
  void readFileInResource() throws Exception
  {
    List<String> expected = new ArrayList<>();
    expected.add("5 5");
    expected.add("1 2 N");
    expected.add("LFLFLFLFF");
    expected.add("3 3 E");
    expected.add("FFRFFRFRRF");
    assertThat(FileUtils.readFileInResource("input")).isEqualTo(expected);
  }
}