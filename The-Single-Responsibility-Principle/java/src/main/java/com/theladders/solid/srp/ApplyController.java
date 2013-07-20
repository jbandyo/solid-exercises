package com.theladders.solid.srp;


import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.view.View;

public class ApplyController
{
  private final ApplyHandler applyHandler;

  public ApplyController(ApplyHandler _applyHandler)
  {
    applyHandler = _applyHandler;
  }
  
  public HttpResponse getResponse(HttpRequest request)
  {
    RequestParser parser = new RequestParser(request);
    
    Result result = applyHandler.handleApplyRequest(parser);
    
    return new View(result).getResponse();    
  }

}
