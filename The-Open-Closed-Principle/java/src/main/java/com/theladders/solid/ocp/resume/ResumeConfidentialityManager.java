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
    confidentialPhraseCategory.addPhraseCategory("Name", false);
    confidentialPhraseCategory.addPhraseCategory("MailingAddress", true);
    confidentialPhraseCategory.addPhraseCategory("PhoneNumber", true);
    confidentialPhraseCategory.addPhraseCategory("EmailAddress", true);
    confidentialPhraseCategory.addPhraseCategory("ContactInfo", true);
    confidentialPhraseCategory.addPhraseCategory("CompanyName", false);
    confidentialPhraseCategory.addPhraseCategory("WorkExperience", false);
  }

  public void makeAllContactInfoNonConfidential(User user)
  {
    confidentialResumeHandler.makeSelectedCategoriesNonConfidential(user, confidentialPhraseCategory.getAllContactInfoCategories());
  }

  public void makeAllCategoriesNonConfidential(User user)
  {
    confidentialResumeHandler.makeSelectedCategoriesNonConfidential(user, confidentialPhraseCategory.getAllCategories());
  }
}
