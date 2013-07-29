package com.theladders.solid.isp.oldjob;

public interface JobWithInternalInfo
{
  /**
   * Returns a unique identifier for this job. In the web application, this currently maps to
   * job_location_id in the Database. Scripts may use other values.
   *
   * @return unique identifier for this job.
   */
  int getJobId();

  /**
   * Return the jobsite id for this job.
   *
   * @return jobsite id for this job.
   */
  int getJobSiteId();

  /**
   * Returns the real job_id.
   *
   * @return job id
   */
  Integer getParentJobId();

  int getOldJobId();

  int getSubscriberId();

  /**
   * Get the (internally set) editor's note.
   *
   * @return editor's note.
   */
  String getEditorNote();

  /**
   * Get the URL for this job. This is only valid for external (harvested) jobs (! isJobReq).
   *
   * @return URL for this job.
   */
  String getUrl();


}
