package com.theladders.solid.dip;

import java.util.Date;

public interface ReadOnlyArticleMetadata //Todo: remove methods that don't fit here
{

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSuggestedArticleId()
   */
  public Integer getSuggestedArticleId();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSubscriberId()
   */
  public Integer getSubscriberId();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSuggestedArticleSourceId()
   */
  public Integer getSuggestedArticleSourceId();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getArticleExternalIdentifier()
   */
  public String getArticleExternalIdentifier();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSuggestedArticleStatusId()
   */
  public Integer getSuggestedArticleStatusId();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getCreateTime()
   */
  public Date getCreateTime();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getCreatorId()
   */
  public Integer getCreatorId();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getUpdateTime()
   */
  public Date getUpdateTime();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getUpdaterId()
   */
  public Integer getUpdaterId();

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getNote()
   */
  public String getNote();

}
