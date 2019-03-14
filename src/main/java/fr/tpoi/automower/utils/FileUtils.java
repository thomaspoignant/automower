package fr.tpoi.automower.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class FileUtils {

  public static List<String> readFileInResource(final String fileName) throws IOException {
    URL url = Resources.getResource(fileName);
    return Resources.readLines(url, Charsets.UTF_8);
  }
}
