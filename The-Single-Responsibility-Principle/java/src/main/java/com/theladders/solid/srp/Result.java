package com.theladders.solid.srp;

import java.util.List;
import java.util.Map;

public class Result
{
  private final ResultCode type;
  private final Map<String, Object> model;
  private final List<String> errorList;

  public Result(ResultCode type,
                Map<String, Object> model)
  {
    this.type  = type;
    this.model = model;
    this.errorList = null;
  }

  public Result(ResultCode type,
                Map<String, Object> model,
                List<String> errList)
  {
    this.type  = type;
    this.model = model;
    this.errorList = errList;
  }

  public ResultCode getType()
  {
    return type;
  }

  @Override
  public String toString()
  {
    return "Result [type=" + type + ", model=" + model + ", errorList=" + errorList + "]";
  }
}
