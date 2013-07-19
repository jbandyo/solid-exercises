package com.theladders.solid.srp;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.jobseeker.ProfileStatus;


public class ProfilePolicy
{
  private final JobseekerProfileManager jobseekerProfileManager;

  public ProfilePolicy(JobseekerProfileManager jobseekerProfileManager)
  {
    this.jobseekerProfileManager = jobseekerProfileManager;
  }
    
  public boolean resumeIncomplete(Jobseeker jobseeker)
  {
    JobseekerProfile profile = jobseekerProfileManager.getJobSeekerProfile(jobseeker);
    if (profile == null)
      return true;

    return (!jobseeker.isPremium() && (profile.getStatus().equals(ProfileStatus.INCOMPLETE) ||
        profile.getStatus().equals(ProfileStatus.NO_PROFILE) ||
        profile.getStatus().equals(ProfileStatus.REMOVED)));
  }

}
