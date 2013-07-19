package com.theladders.solid.srp.http;

import com.theladders.solid.srp.Result;

public class HttpResponse
{
  private Result result;

  public String getResultType()
  {
    return result.getType().message();
  }

  public void setResult(Result result)
  {
    this.result = result;
  }
}
