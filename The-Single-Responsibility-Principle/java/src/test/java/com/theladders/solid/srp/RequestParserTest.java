package com.theladders.solid.srp;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Test;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpSession;
import com.theladders.solid.srp.jobseeker.Jobseeker;

public class RequestParserTest
{
  private static final int APPROVED_JOBSEEKER    = 1010;

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  @Test
  public void testInstance()
  {
    Jobseeker JOBSEEKER = new Jobseeker(APPROVED_JOBSEEKER, true);
    HttpSession session = new HttpSession(JOBSEEKER);
    Map<String, String> parameters = new HashMap<>();
    parameters.put("jobId","555");
    parameters.put("newResumeFileName", "myresume");
    HttpRequest request = new HttpRequest(session, parameters);
    RequestParser parser = new RequestParser(request);
    assertEquals("RequestParser must parse JobID correctly", parser.jobId, 555);
    assertEquals("RequestParser must parse JobSeeker correctly", parser.jobseeker, JOBSEEKER);
    assertEquals("RequestParser must parse newResumeFileName correctly", parser.newResumeFileName, "myresume");
    
    parameters = new HashMap<>();
    parameters.put("whichResume", "existing");
    parameters.put("makeResumeActive", "yes");
    request = new HttpRequest(session, parameters);
    parser = new RequestParser(request);
    assertTrue("RequestParser must parse useExistingResume correctly", parser.useExistingResume);
    assertTrue("RequestParser must parse makeResumeActive correctly", parser.makeResumeActive);

    parameters = new HashMap<>();
    parameters.put("whichResume", "new");
    parameters.put("makeResumeActive", "no");
    request = new HttpRequest(session, parameters);
    parser = new RequestParser(request);
    assertFalse("RequestParser must parse useExistingResume correctly", parser.useExistingResume);
    assertFalse("RequestParser must parse makeResumeActive correctly", parser.makeResumeActive);
  
  }

  @Test
  public void testInstanceWithNullParams()
  {
    Jobseeker JOBSEEKER = new Jobseeker(APPROVED_JOBSEEKER, true);
    HttpSession session = new HttpSession(JOBSEEKER);
    Map<String, String> parameters = new HashMap<>();
    HttpRequest request = new HttpRequest(session, parameters);
    RequestParser parser = new RequestParser(request);
    assertEquals("RequestParser must put default when a param does not exist", parser.jobId, -1);
    assertFalse("RequestParser must put default when a param does not exist", parser.useExistingResume);
    assertFalse("RequestParser must put default when a param does not exist", parser.makeResumeActive);
    assertEquals("RequestParser must put default when a param does not exist", parser.newResumeFileName, null);
  }

}
