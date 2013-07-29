package com.theladders.solid.isp.oldjob;

import java.util.Date;

public interface JobWithDateInfo
{
  /**
   * Get the date this job was originally published
   *
   * @return the Date the job was originally published
   */
  Date getOriginalPublicationDate();

  /**
   * Get the date this job was entered into the system.
   *
   * @return the Date the job was entered.
   */
  Date getEntryDate();

  /**
   * Get the date this job was published.
   *
   * @return the Date the job was published.
   */
  Date getPublicationDate();

  /**
   * @return The last time this job was updated
   */
  Date getUpdateTime();

}
