package com.theladders.solid.dip.images;

import java.util.HashMap;
import java.util.Map;

import com.theladders.solid.dip.ImageManager;

public class ImageHelper implements ImageManager
{

  private static final String IMAGE_PREFIX = "http://somecdnprodiver.com/static/images/careerAdvice/";
  private static final Map<String, String> CATEGORY_IMAGE_MAP = new HashMap<>();

  static
  {
    CATEGORY_IMAGE_MAP.put("Interviewing", "interviewing_thumb.jpg");
    CATEGORY_IMAGE_MAP.put("Job Search", "job_search_thumb.jpg");
    CATEGORY_IMAGE_MAP.put("Networking", "networking_thumb.jpg");
    CATEGORY_IMAGE_MAP.put("Personal Branding", "personalBranding_thumb.jpg");
    CATEGORY_IMAGE_MAP.put("Resume", "resume_thumb.jpg");
    CATEGORY_IMAGE_MAP.put("Salary", "salary_thumb.jpg");
    CATEGORY_IMAGE_MAP.put("Assessment", "salary_thumb.jpg");
    CATEGORY_IMAGE_MAP.put("On the Job", "salary_thumb.jpg");
  }

  @Override
  public String getImageFilePath(String category)
  {
    String filename = CATEGORY_IMAGE_MAP.get(category);
    return IMAGE_PREFIX+filename;
  }

}
