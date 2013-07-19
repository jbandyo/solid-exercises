package com.theladders.solid.srp;

public enum ResultCode
{
  SUCCESS ("success"),
  ERROR("error"),
  INVALID_JOB("invalidJob"),
  RESUME_INCOMPLETE("completeResumePlease");
  
  private String message;
  
  ResultCode(String msg)
  {
    message = msg;
  }
  
  public String message()
  {
    return message;
  }

}
