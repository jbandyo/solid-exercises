package com.theladders.solid.ocp.resume;

import java.util.EnumSet;

public enum ConfidentialPhraseCategory
{
  Name(76),
  MailingAddress(79),
  PhoneNumber(78),
  EmailAddress(77),
  ContactInfo(80),
  CompanyName(81),
  WorkExperience(82);

  public static final EnumSet<ConfidentialPhraseCategory> allCategories;
  public static final EnumSet<ConfidentialPhraseCategory> allContactInfo;
  
  static
  {
    allCategories = EnumSet.allOf(ConfidentialPhraseCategory.class);
    allContactInfo = EnumSet.of(ConfidentialPhraseCategory.PhoneNumber,
                             ConfidentialPhraseCategory.EmailAddress,
                             ConfidentialPhraseCategory.MailingAddress,
                             ConfidentialPhraseCategory.ContactInfo);
  }
  
  @SuppressWarnings("unused")
  private int id;

  private ConfidentialPhraseCategory(int id)
  {
    this.id = id;
  }
}
