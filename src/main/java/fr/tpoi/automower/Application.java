package fr.tpoi.automower;

import fr.tpoi.automower.bean.Garden;
import fr.tpoi.automower.exception.InvalidInputFile;
import fr.tpoi.automower.service.InputFileExtractor;

import java.io.IOException;

public class Application
{

  public static void main (String... args)
  {
    try{
      InputFileExtractor input = InputFileExtractor.extractInputFile("input");
      Garden garden = Garden.builder().maxX(input.getMaxX()).maxY(input.getMaxY()).mowers(input.getAutomowerAndMove()).build();
      garden.moveAutomowers();
      garden.getMowers()
            .forEach((mower,movementLine)->System.out.println(mower));
    } catch (InvalidInputFile invalidInputFile) {
      System.err.println(invalidInputFile.getMessage());
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}
