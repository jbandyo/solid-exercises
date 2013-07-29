package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.stubs.PositionLevel;

public interface JobWithPositionInfo
{
  /**
   * Get the "reportsTo" field.
   *
   * @return reportsTo
   */
  String getReportsTo();

  PositionLevel getPositionLevel();

}
