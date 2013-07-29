package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.stubs.Industry;
import com.theladders.solid.isp.oldjob.stubs.Sector;

public interface JobWithGroupInfo
{
  /**
   * Get the Industry for this job.
   *
   * @return the Industry for this job.
   */
  Industry getIndustry();

  /**
   * Get the sector for this job.
   *
   * @return the sector for this job.
   */
  Sector getSector();

}
