package com.theladders.solid.isp.oldjob;

public interface JobWithTypeInfo
{
  /**
   * @return returns true if this job was posted anonymously
   */
  boolean isAnonymous();

  boolean isConfidential();

  boolean isExclusive();

  /**
   * Is this job a JobReq? JobReqs are jobs entered into our site directly by recruiters.
   *
   * @return true if job is a JobReq, false otherwise.
   */
  boolean isJobReq();

  boolean isReimbursable();

  /**
   * Is this job a Marketing job? If this flag is set, basic access is allowed to this job (where
   * otherwise it would be premium) from certain landing pages.
   *
   * @return true if this is marked for marketing, false otherwise.
   */
  // TODO: This should only ever be true for JobReq, refactor into the JobReq interface
  boolean isMarketing();

}
