package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.ActiveResumeRepository;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;
import com.theladders.solid.srp.resume.ResumeRepository;

public class ResumePolicyTest
{
  private static final int JOBSEEKER_WITH_RESUME = 777;

  private ResumeRepository       resumeRepository;
  private ActiveResumeRepository activeResumeRepository;
  private ResumePolicy resumePolicy;
 
  private Jobseeker jobseeker;
  private Resume givenResume;
  private Resume activeResume;
  private Resume newResume;
  private boolean useExistingResume;
  private boolean makeResumeActive;
  private String newResumeFileName;

  @Before
  public void setup()
  {
    jobseeker = new Jobseeker(JOBSEEKER_WITH_RESUME, true);
    resumeRepository = new ResumeRepository();
    activeResumeRepository = new ActiveResumeRepository();
    ResumeManager resumeManager = new ResumeManager(resumeRepository);
    MyResumeManager myResumeManager = new MyResumeManager(activeResumeRepository);
    resumePolicy = new ResumePolicy(resumeManager, myResumeManager);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  private void givenUsingExistingResume()
  {
    useExistingResume = true;
    makeResumeActive  = false;
    newResumeFileName = null;
    givenResume = new Resume("Blammo");
    activeResumeRepository.makeActive(JOBSEEKER_WITH_RESUME, givenResume);
  }
  
  private void givenUsingNewResume()
  {
    useExistingResume = false;
    makeResumeActive  = true;
    newResumeFileName = "otherResume";
    newResume = new Resume("otherResume");
  }

  private void givenUsingNoResume()
  {
    useExistingResume = false;
    makeResumeActive  = true;
    newResumeFileName = null;
  }

  private void whenSavingNewOrRetrievingExistingResume()
  {
    activeResume = resumePolicy.saveNewOrRetrieveExistingResume(jobseeker, useExistingResume, makeResumeActive, newResumeFileName);    
  }

  private void thenReceiveActiveResume(Resume expected, Resume actual)
  {
    assertEquals("ResumePolicy must return correct active resume", expected, actual);
  }
  
  private void thenReceiveNewResume(Resume expected, Resume actual)
  {
    assertEquals("ResumePolicy must return correct active resume", expected, actual);
  }

  @Test
  public void testWithExistingResume()
  {
    givenUsingExistingResume();
    whenSavingNewOrRetrievingExistingResume();
    thenReceiveActiveResume(givenResume, activeResume);
  }
  
  @Test
  public void testWithNewResume()
  {
    givenUsingNewResume();
    whenSavingNewOrRetrievingExistingResume();
    thenReceiveNewResume(newResume, activeResume);
  }

  @Test(expected = NullPointerException.class)
  public void testWithNoResume()
  {
    givenUsingNoResume();
    whenSavingNewOrRetrievingExistingResume();
    //then get exception
  }

}
