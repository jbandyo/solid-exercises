package com.theladders.solid.dip;

import java.util.EnumSet;
import java.util.List;

public interface ArticleMetadataProvider
{
  enum ArticleStatus
  {
    NEW,
    VIEWED
  }
  
  enum ArticleOrderField
  {
    CREATE_TIME,
    DESC
  }
  
  public List<ReadOnlyArticleMetadata> getArticlesbySubscriber(Integer subscriberId, 
                                                               EnumSet<ArticleStatus> status,
                                                               ArticleOrderField orderByFirst,
                                                               ArticleOrderField orderBySecond);

  public int createArticle(Integer subscriberId,
                           String articleExternalIdentifier,
                           String note,
                           Integer creatorId);

  public void updateNote(Integer articleId, String note);

  public void markRecomDeleted(Integer articleId);

}
