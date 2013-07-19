package com.theladders.solid.view;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

import com.theladders.solid.srp.Result;
import com.theladders.solid.srp.ResultCode;
import com.theladders.solid.srp.http.HttpResponse;

public class ViewTest
{

  @Test
  public void testSuccessView()
  {
    Map<String, Object> params = new HashMap<>();
    params.put("jobId", 555);
    params.put("jobTitle", "Developer");
    Result result = new Result(ResultCode.SUCCESS, params);
    View view = new View(result);
    assertNotNull("SuccessView constructor must create the instance, view");
    HttpResponse resp = view.getResponse();
    assertEquals("SuccessView must create response with proper Result type", resp.getResultType(), "success");
  }

  @Test
  public void testErrorView()
  {
    Map<String, Object> params = new HashMap<>();
    params.put("jobId", 555);
    params.put("jobTitle", "Developer");
    Result result = new Result(ResultCode.ERROR, params);
    View view = new View(result);
    assertNotNull("SuccessView constructor must create the instance, view");
    HttpResponse resp = view.getResponse();
    assertEquals("SuccessView must create response with proper Result type", resp.getResultType(), "error");
  }

  @Test
  public void testInvalidView()
  {
    Map<String, Object> params = new HashMap<>();
    params.put("jobId", 555);
    params.put("jobTitle", "Developer");
    Result result = new Result(ResultCode.INVALID_JOB, params);
    View view = new View(result);
    assertNotNull("SuccessView constructor must create the instance, view");
    HttpResponse resp = view.getResponse();
    assertEquals("SuccessView must create response with proper Result type", resp.getResultType(), "invalidJob");
  }

  @Test
  public void testResumeIncompleteView()
  {
    Map<String, Object> params = new HashMap<>();
    params.put("jobId", 555);
    params.put("jobTitle", "Developer");
    Result result = new Result(ResultCode.RESUME_INCOMPLETE, params);
    View view = new View(result);
    assertNotNull("SuccessView constructor must create the instance, view");
    HttpResponse resp = view.getResponse();
    assertEquals("SuccessView must create response with proper Result type", resp.getResultType(), "completeResumePlease");
  }

}
