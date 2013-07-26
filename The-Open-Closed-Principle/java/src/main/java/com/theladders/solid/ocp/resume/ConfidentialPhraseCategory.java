package com.theladders.solid.ocp.resume;

import java.util.*;

public class ConfidentialPhraseCategory
{
  private Set<String> allCategories = new HashSet<String>();
  private Set<String> allContactInfo = new HashSet<String>();
  
  public ConfidentialPhraseCategory()
  {
    addPhraseCategory("Name", false);
    addPhraseCategory("MailingAddress", true);
    addPhraseCategory("PhoneNumber", true);
    addPhraseCategory("EmailAddress", true);
    addPhraseCategory("ContactInfo", true);
    addPhraseCategory("CompanyName", false);
    addPhraseCategory("WorkExperience", false);
  }
  
  public void addPhraseCategory(String category, boolean isContactInfo)
  {
    assert(category != null);
    assert(category.length() != 0);
    
    allCategories.add(category);
    if (isContactInfo)
      allContactInfo.add(category);
  }
  
  public String[] getAllCategoryPhrases()
  {
    return (String[])allCategories.toArray();
  }
  
  public String[] getAllContactInfoPhrases()
  {
    return (String[])allContactInfo.toArray();
  }

}
