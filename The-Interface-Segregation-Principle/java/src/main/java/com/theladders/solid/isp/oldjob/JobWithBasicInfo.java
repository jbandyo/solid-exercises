package com.theladders.solid.isp.oldjob;

public interface JobWithBasicInfo
{
  /**
   * Get this job's title.
   *
   * @return the title for this job.
   */
  String getTitle();

  /**
   * Get description for this job.
   *
   * @return the description for this job.
   */
  String getDescription();

  /**
   * Get this job's short description.
   *
   * @return a summary description of this job.
   */
  String getShortDescription();

}
