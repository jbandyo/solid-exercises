package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.jobseeker.JobseekerProfileRepository;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class ProfilePolicyTest
{
  private static final int NOPROFILE_JOBSEEKER   = 777;
  private static final int INCOMPLETE_JOBSEEKER  = 888;
  private static final int REMOVED_JOBSEEKER     = 1010;

  private Jobseeker jobseeker;
  private JobseekerProfileRepository jobseekerProfileRepository;
  private ProfilePolicy profilePolicy;
  private boolean profileIncomplete;

  @Before
  public void setup()
  {
    setupJobseekerProfileRepository();
    JobseekerProfileManager jobseekerProfileManager = new JobseekerProfileManager(jobseekerProfileRepository);
    profilePolicy = new ProfilePolicy(jobseekerProfileManager);  
  }
  
  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}
  
  private void addToJobseekerProfileRepository(int id, ProfileStatus status)
  {
    JobseekerProfile profile = new JobseekerProfile(id, status);
    jobseekerProfileRepository.addProfile(profile);
  }

  private void setupJobseekerProfileRepository()
  {
    jobseekerProfileRepository = new JobseekerProfileRepository();
    addToJobseekerProfileRepository(REMOVED_JOBSEEKER, ProfileStatus.REMOVED);
    addToJobseekerProfileRepository(INCOMPLETE_JOBSEEKER, ProfileStatus.INCOMPLETE);
  }

  private void givenJobSeekerIsPremium()
  {
    jobseeker = new Jobseeker(INCOMPLETE_JOBSEEKER, true);
  }

  private void givenJobSeekerIsNotPremiumAndStatusIsIncomplete()
  {
    jobseeker = new Jobseeker(INCOMPLETE_JOBSEEKER, false);
  }

  private void givenJobSeekerIsNotPremiumAndStatusIsRemoved()
  {
    jobseeker = new Jobseeker(REMOVED_JOBSEEKER, false);
  }

  private void givenJobSeekerIsNotPremiumAndStatusIsNoProfile()
  {
    jobseeker = new Jobseeker(NOPROFILE_JOBSEEKER, false);
  }

  private void whenCheckingResumeStatus()
  {
    profileIncomplete = profilePolicy.resumeIncomplete(jobseeker);
  }
  
  private void thenResumeisNotIncomplete()
  {
    assertFalse(profileIncomplete);
  }

  private void thenResumeisIncomplete()
  {
    assertTrue(profileIncomplete);
  }

  @Test
  public void testWithPremium()
  {
    givenJobSeekerIsPremium();
    whenCheckingResumeStatus();
    thenResumeisNotIncomplete();
  }

  @Test
  public void testWithNotPremiumIncompleteStatus()
  {
    givenJobSeekerIsNotPremiumAndStatusIsIncomplete();
    whenCheckingResumeStatus();
    thenResumeisIncomplete();
  }

  @Test
  public void testWithNotPremiumRemovedStatus()
  {
    givenJobSeekerIsNotPremiumAndStatusIsRemoved();
    whenCheckingResumeStatus();
    thenResumeisIncomplete();
  }

  @Test
  public void testWithNotPremiumNoProfileStatus()
  {
    givenJobSeekerIsNotPremiumAndStatusIsNoProfile();
    whenCheckingResumeStatus();
    thenResumeisIncomplete();
  }

}
