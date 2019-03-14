package fr.tpoi.automower.service;

import fr.tpoi.automower.bean.Automower;
import fr.tpoi.automower.bean.Movement;
import fr.tpoi.automower.bean.Orientation;
import fr.tpoi.automower.exception.InvalidInputFile;
import fr.tpoi.automower.utils.FileUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class InputFileExtractor
{
  private int maxX;
  private int maxY;
  private Map<Automower, Movement> automowerAndMove;
  
  public static InputFileExtractor extractInputFile(final String filename) throws IOException, InvalidInputFile
  {
    //read file
    List<String> lines = FileUtils.readFileInResource(filename);
    
    //get information for firstline
    String[] configSquareLine = lines.get(0).split(" ");
    if(configSquareLine.length!=2
        || !NumberUtils.isCreatable(configSquareLine[0])
        || !NumberUtils.isCreatable(configSquareLine[1])){
      throw new InvalidInputFile();
    }
    
    InputFileExtractor inputFileExtractor = new InputFileExtractor();
  
    inputFileExtractor.setMaxX(Integer.parseInt(configSquareLine[0]));
    inputFileExtractor.setMaxY(Integer.parseInt(configSquareLine[1]));
    
    //get automower and there movement
    Map<Automower, Movement> movementLineMap = new HashMap<>();
    
    int lineIterator = 1;
    while(lineIterator<lines.size()){
      String mowerLine = lines.get(lineIterator);
      String[] mowerLineElements = mowerLine.split(" ");
      
      if(mowerLineElements.length!=3
          || !NumberUtils.isCreatable(mowerLineElements[0])
          || !NumberUtils.isCreatable(mowerLineElements[1])
          || mowerLineElements[2].length()!=1){
        throw new InvalidInputFile();
      }
      
      Automower currentAutomower = Automower.builder()
                                            .x(Integer.parseInt(mowerLineElements[0]))
                                            .y(Integer.parseInt(mowerLineElements[1]))
                                            .orientation(Orientation.valueOf(mowerLineElements[2]))
                                            .build();
      Movement currentAutomowerMove = Movement.builder().movementLine(lines.get(lineIterator+1)).build();
      movementLineMap.put(currentAutomower,currentAutomowerMove);
      inputFileExtractor.setAutomowerAndMove(movementLineMap);
      
      lineIterator=lineIterator+2;
    }
    
    return inputFileExtractor;
  }
}
