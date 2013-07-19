package com.theladders.solid.srp;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class ResumePolicy
{
  private final ResumeManager resumeManager;
  private final MyResumeManager myResumeManager;
  
  public ResumePolicy(ResumeManager resumeManager,
                      MyResumeManager myResumeManager)
  {
    this.resumeManager = resumeManager;
    this.myResumeManager = myResumeManager;
  }
  
  public Resume saveNewOrRetrieveExistingResume(Jobseeker jobseeker, boolean useExistingResume, boolean makeResumeActive, String newResumeFileName)
  {
    Resume resume;
    if (!useExistingResume)
    {
      resume = resumeManager.saveResume(jobseeker, newResumeFileName);

      if (resume != null && makeResumeActive)
      {
        myResumeManager.saveAsActive(jobseeker, resume);
      }
    }
    else
    {
      resume = myResumeManager.getActiveResume(jobseeker.getId());
    }

    return resume;
  }

}
