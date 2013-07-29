package com.theladders.solid.isp.oldjob;

import java.util.Collection;
import java.util.List;

import com.theladders.solid.isp.oldjob.stubs.Discipline;
import com.theladders.solid.isp.oldjob.stubs.Experience;
import com.theladders.solid.isp.oldjob.stubs.JobFunction;

public interface JobWithDetailsInfo
{
  /**
   * Retrieves a list of disciplines for this job.
   *
   * @return List of Disciplines
   */
  List<Discipline> getDisciplines();

  /**
   * Returns an object that represents the number of years of experience
   * that are required for this job.
   * @return experience object
   */
  Experience getExperience();

  /**
   * 
   * @return Job functions
   */
  Collection<JobFunction> getJobFunctions();

}
