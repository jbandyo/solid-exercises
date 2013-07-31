package com.theladders.solid.dip;

import java.util.Date;

public interface WriteOnlyArticleMetadata
{

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSuggestedArticleId(java.lang.Integer)
   */
  public void setSuggestedArticleId(Integer suggestedArticleId);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSubscriberId(java.lang.Integer)
   */
  public void setSubscriberId(Integer subscriberId);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSuggestedArticleSourceId(java.lang.Integer)
   */
  public void setSuggestedArticleSourceId(Integer suggestedArticleSourceId);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setArticleExternalIdentifier(java.lang.String)
   */
  public void setArticleExternalIdentifier(String articleExternalIdentifier);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSuggestedArticleStatusId(java.lang.Integer)
   */
  public void setSuggestedArticleStatusId(Integer suggestedArticleStatusId);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setCreateTime(java.util.Date)
   */
  public void setCreateTime(Date createTime);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setCreatorId(java.lang.Integer)
   */
  public void setCreatorId(Integer creatorId);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setUpdateTime(java.util.Date)
   */
  public void setUpdateTime(Date updateTime);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setUpdaterId(java.lang.Integer)
   */
  public void setUpdaterId(Integer updaterId);

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setNote(java.lang.String)
   */
  public void setNote(String note);

}
