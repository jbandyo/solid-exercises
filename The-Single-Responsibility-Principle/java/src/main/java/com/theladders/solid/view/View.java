package com.theladders.solid.view;

import com.theladders.solid.srp.Result;
import com.theladders.solid.srp.http.HttpResponse;

public class View
{
  private final Result result;
  
  public View(Result _result)
  {
    result = _result;
  }
  
  public HttpResponse getResponse()
  {
    HttpResponse response = new HttpResponse();
    response.setResult(result);
    return response;
  }

}
