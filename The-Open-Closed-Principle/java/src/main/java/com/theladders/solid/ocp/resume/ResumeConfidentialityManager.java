package com.theladders.solid.ocp.resume;

import com.theladders.solid.ocp.user.User;

public class ResumeConfidentialityManager
{
  private final ConfidentialResumeHandler confidentialResumeHandler;
  
  //private final EnumSet<ConfidentialPhraseCategory> allCategories;
  

  public ResumeConfidentialityManager(ConfidentialResumeHandler confidentialResumeHandler)
  {
    this.confidentialResumeHandler = confidentialResumeHandler;
    //allCategories = EnumSet.allOf(ConfidentialPhraseCategory.class);
  }

  public void makeAllContactInfoNonConfidential(User user)
  {
    confidentialResumeHandler.makeSelectedCategoriesNonConfidential(user, ConfidentialPhraseCategory.allContactInfo);
  }

  public void makeAllCategoriesNonConfidential(User user)
  {
    confidentialResumeHandler.makeSelectedCategoriesNonConfidential(user, ConfidentialPhraseCategory.allCategories);
  }
}
