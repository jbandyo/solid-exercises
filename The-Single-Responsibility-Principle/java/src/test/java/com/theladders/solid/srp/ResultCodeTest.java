package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class ResultCodeTest
{

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  @Test
  public void testInstance()
  {
    ResultCode code = ResultCode.ERROR;
    assertEquals("ResultCode message is not correct", code.message(), "error");
    code = ResultCode.INVALID_JOB;
    assertEquals("ResultCode message is not correct", code.message(), "invalidJob");
    code = ResultCode.RESUME_INCOMPLETE;
    assertEquals("ResultCode message is not correct", code.message(), "completeResumePlease");
  }

}
