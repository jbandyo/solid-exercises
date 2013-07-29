package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.stubs.Industry;
import com.theladders.solid.isp.oldjob.stubs.Sector;

public interface JobWithCompanyInfo
{
  /**
   * @return the name of the company
   */
  String getCompany();

  /**
   * Gets the value of the company_size_id field.
   * This represents the id in the company size table for the description of
   * how large the company is.
   *
   * @return companySize
   */
  Integer getCompanySize();

 }
