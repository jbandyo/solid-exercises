package com.theladders.solid.isp.oldjob;

import java.util.List;

import com.theladders.solid.isp.oldjob.stubs.Discipline;

public interface JobWithCompensationInfo
{
  /**
   * Get this job's compensation (text).
   *
   * @return compensation for this job.
   */
  String getCompensation();

  /**
   * Get this job's compensationSalary (text).
   *
   * @return compensationSalary for this job.
   */
  String getCompensationSalary();

  /**
   * Get this job's compensationBonus (text).
   *
   * @return compensationBonus for this job.
   */
  String getCompensationBonus();

  /**
   * Get this job's compensationOther (text).
   *
   * @return compensationOther for this job.
   */
  String getCompensationOther();

  /**
   * Retrieves a list of disciplines for this job.
   *
   * @return List of Disciplines
   */
  List<Discipline> getDisciplines();

}
