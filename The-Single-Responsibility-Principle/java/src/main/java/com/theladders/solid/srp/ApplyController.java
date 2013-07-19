package com.theladders.solid.srp;


import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.job.JobSearchService;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.ResumeManager;
import com.theladders.solid.view.*;

public class ApplyController
{
  private final ApplyHandler applyHandler;

  public ApplyController(JobseekerProfileManager jobseekerProfileManager,
                      JobSearchService jobSearchService,
                      JobApplicationSystem jobApplicationSystem,
                      ResumeManager resumeManager,
                      MyResumeManager myResumeManager)
  {
    applyHandler = new ApplyHandler(jobseekerProfileManager,
                                     jobSearchService,
                                     jobApplicationSystem,
                                     resumeManager,
                                     myResumeManager);
  }
  
  public HttpResponse getResponse(HttpRequest request)
  {
    RequestParser parser = new RequestParser(request);
    
    Result result = applyHandler.handleApplyRequest(parser);
    
    return new View(result).getResponse();    
  }

}
