package com.theladders.solid.dip.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import com.theladders.solid.dip.ReadOnlyArticleMetadata;
import com.theladders.solid.dip.ArticleMetadataProvider;

public class SuggestedArticleMetadataProvider implements ArticleMetadataProvider
{
  private SuggestedArticleDao   suggestedArticleDao;
  
  private Map<ArticleOrderField, String> articleOrderByNames = new EnumMap<ArticleOrderField, String>(ArticleOrderField.class);

  public SuggestedArticleMetadataProvider(SuggestedArticleDao suggestedArticleDao)
  {
    this.suggestedArticleDao = suggestedArticleDao;
    articleOrderByNames.put(ArticleOrderField.CREATE_TIME, "create_time");
    articleOrderByNames.put(ArticleOrderField.DESC, "desc");
  }

  public List<ReadOnlyArticleMetadata> getArticlesbySubscriber(Integer subscriberId, 
                                                               EnumSet<ArticleStatus> flags,
                                                               ArticleOrderField orderByFirst,
                                                               ArticleOrderField orderBySecond)
  {
    SuggestedArticleExample criteria = new SuggestedArticleExample();
    List<Integer> statusList = createArticleStatusIdList(flags);
    criteria.createCriteria()
            .andSubscriberIdEqualTo(subscriberId)
            .andSuggestedArticleStatusIdIn(statusList)  // must be New or Viewed
            .andSuggestedArticleSourceIdEqualTo(1);     // ??

    String orderByClause = createOrderByClause(orderByFirst, orderBySecond);
    criteria.setOrderByClause(orderByClause);
    
    List<SuggestedArticle> dbArticles = this.suggestedArticleDao.selectByExampleWithBlobs(criteria);

    List<ReadOnlyArticleMetadata> metaList = new ArrayList<ReadOnlyArticleMetadata>();
    for (SuggestedArticle article : dbArticles)
    {
      metaList.add(article);
    }
    return metaList;
  }

  private String createOrderByClause(ArticleOrderField orderByFirst,
                                     ArticleOrderField orderBySecond)
  {
    String orderByClause = articleOrderByNames.get(orderByFirst);
    orderByClause += " " + articleOrderByNames.get(orderBySecond);
    return orderByClause;
  }

  private List<Integer> createArticleStatusIdList(EnumSet<ArticleStatus> flags)
  {
    List<Integer> statusList = new ArrayList<Integer>();
    for (ArticleStatus flag : flags)
    {
      statusList.add(flag.ordinal());   // Todo: use EnumMap
    }
    return statusList;
  }

  @Override
  public int createArticle(Integer subscriberId,
                           String articleExternalIdentifier,
                           String note,
                           Integer creatorId)
  {
    Integer STATUS_UNREAD = 1;
    Integer HTP_CONSULTANT = 1;    
    SuggestedArticle suggestedArticle = new SuggestedArticle(subscriberId,
                                                             articleExternalIdentifier,
                                                             note,
                                                             creatorId);
    suggestedArticle.setSubscriberId(subscriberId);
    suggestedArticle.setSuggestedArticleStatusId(STATUS_UNREAD);
    suggestedArticle.setSuggestedArticleSourceId(HTP_CONSULTANT);
    suggestedArticle.setCreateTime(new Date()); // current date
    suggestedArticle.setUpdateTime(new Date()); // current date
    int newId = suggestedArticleDao.insertReturnId(suggestedArticle);
    return newId;
  }

  @Override
  public void updateNote(Integer articleId,
                         String note)
  {
    SuggestedArticle article = new SuggestedArticle();
    article.setSuggestedArticleId(articleId);
    article.setNote(note);
    suggestedArticleDao.updateByPrimaryKeySelective(article);    
  }

  @Override
  public void markRecomDeleted(Integer articleId)
  {
    Integer STATUS_DELETED = 4;
    SuggestedArticle article = new SuggestedArticle();
    article.setSuggestedArticleId(articleId);
    article.setSuggestedArticleStatusId(STATUS_DELETED);
    suggestedArticleDao.updateByPrimaryKeySelective(article);
  }

}
