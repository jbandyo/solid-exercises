package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.jobseeker.Jobseeker;

public class RequestParser
{
  public final Jobseeker jobseeker;
  public final int jobId;
  public final boolean useExistingResume;
  public final boolean makeResumeActive;
  public final String newResumeFileName;
  
  public RequestParser(HttpRequest request)
  {
    jobseeker = request.getSession().getJobseeker();
    String jobIdString  = request.getParameter("jobId");
    jobId = jobIdString == null ? -1 : Integer.parseInt(jobIdString);
    request.getParameter("whichResume");
    useExistingResume = "existing".equals(request.getParameter("whichResume"));
    makeResumeActive = "yes".equals(request.getParameter("makeResumeActive"));
    newResumeFileName = request.getParameter("newResumeFileName");
  }
}
