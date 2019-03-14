package fr.tpoi.automower.exception;

public class InvalidInputFile extends Exception
{
  public InvalidInputFile(final String reason){
    this(reason,null);
  }

  public InvalidInputFile(final String reason, final Throwable throwable){
    super("The format of the input file is not correct, reason: "+reason,throwable);
  }
}
