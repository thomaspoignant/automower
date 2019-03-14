package fr.tpoi.automower.exception;

public class InvalidInputFile extends Exception
{
  public InvalidInputFile(){
    super("The format of the input file is not correct");
  }
}
