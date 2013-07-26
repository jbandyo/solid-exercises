package com.theladders.solid.ocp.resume;

import com.theladders.solid.ocp.user.User;

public class ResumeConfidentialityManager
{
  private final ConfidentialResumeHandler confidentialResumeHandler;
  private final ConfidentialPhraseCategory confidentialPhraseCategory;
   

  public ResumeConfidentialityManager(ConfidentialResumeHandler confidentialResumeHandler,
                                      ConfidentialPhraseCategory confidentialPhraseCategory)
  {
    this.confidentialResumeHandler = confidentialResumeHandler;
    this.confidentialPhraseCategory = confidentialPhraseCategory;
  }

  public void makeAllContactInfoNonConfidential(User user)
  {
    confidentialResumeHandler.makeSelectedCategoriesNonConfidential(user, confidentialPhraseCategory.getAllContactInfoPhrases());
  }

  public void makeAllCategoriesNonConfidential(User user)
  {
    confidentialResumeHandler.makeSelectedCategoriesNonConfidential(user, confidentialPhraseCategory.getAllCategoryPhrases());
  }
}
