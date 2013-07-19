package com.theladders.solid.srp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.JobSearchService;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class ApplyHandler
{
  public JobseekerProfileManager jobseekerProfileManager;
  public JobSearchService        jobSearchService;
  public JobApplicationSystem    jobApplicationSystem;
  public ResumeManager           resumeManager;
  public MyResumeManager         myResumeManager;

  public ApplyHandler(JobseekerProfileManager jobseekerProfileManager,
                      JobSearchService jobSearchService,
                      JobApplicationSystem jobApplicationSystem,
                      ResumeManager resumeManager,
                      MyResumeManager myResumeManager)
  {
    this.jobseekerProfileManager = jobseekerProfileManager;
    this.jobSearchService = jobSearchService;
    this.jobApplicationSystem = jobApplicationSystem;
    this.resumeManager = resumeManager;
    this.myResumeManager = myResumeManager;  
  }

  public Result handleApplyRequest(RequestParser reqParser)
  {
    Map<String, Object> params = new HashMap<>();
    List<String> errList = new ArrayList<>();

    int jobId = reqParser.jobId;
    Job job = jobSearchService.getJob(jobId);   

    params.put("jobId", jobId);
    if (job == null)
    {
      return new Result(ResultCode.INVALID_JOB, params);
    }
    params.put("jobTitle", job.getTitle());
       
    ResumePolicy resumePolicy = new ResumePolicy(resumeManager, myResumeManager);
    Resume resume = resumePolicy.saveNewOrRetrieveExistingResume(reqParser.jobseeker,
                                                                 reqParser.useExistingResume,
                                                                 reqParser.makeResumeActive,
                                                                 reqParser.newResumeFileName);

    UnprocessedApplication application = new UnprocessedApplication(reqParser.jobseeker, job, resume);
    JobApplicationResult applicationResult = jobApplicationSystem.apply(application);
    if (applicationResult.failure())
    {
      errList.add("We could not process your application.");
      return new Result(ResultCode.ERROR, params, errList);
    }

    ProfilePolicy profilePolicy = new ProfilePolicy(jobseekerProfileManager);  
    if (profilePolicy.resumeIncomplete(reqParser.jobseeker))
    {
      return new Result(ResultCode.RESUME_INCOMPLETE, params);
    }

    return new Result(ResultCode.SUCCESS, params);
  }


}