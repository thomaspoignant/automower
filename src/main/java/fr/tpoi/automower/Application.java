package fr.tpoi.automower;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.bean.Mower;
import fr.tpoi.automower.bean.Orientation;
import fr.tpoi.automower.exception.InvalidInitialPosition;
import fr.tpoi.automower.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Application
{

  public static void main (String... args) throws IOException
  {
    List<String> lines = FileUtils.readFileInResource("input");
    String[] configSquareLine = lines.get(0).split(" ");
    
    if(configSquareLine.length!=2)
    {
      throw new RuntimeException("Invalid init line");
    }
    Garden garden = new Garden(Integer.parseInt(configSquareLine[0]), Integer.parseInt(configSquareLine[1]));
    
    int lineIterator = 1;
    while(lineIterator<lines.size()){
      String mowerLine = lines.get(lineIterator);
      String[] mowerLineElements = mowerLine.split(" ");
      Mower mower = Mower.builder()
                         .x(Integer.parseInt(mowerLineElements[0]))
                         .y(Integer.parseInt(mowerLineElements[1]))
                         .orientation(Orientation.valueOf(mowerLineElements[2]))
                         .build();
      String mowerMove = lines.get(lineIterator+1);
      garden.moveMower(mower,mowerMove);
      System.out.println(mower);
      lineIterator=lineIterator+2;
    }
  }
  
  
  
}
