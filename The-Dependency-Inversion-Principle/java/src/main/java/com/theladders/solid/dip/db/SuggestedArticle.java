package com.theladders.solid.dip.db;

import java.util.Date;

import com.theladders.solid.dip.Column;
import com.theladders.solid.dip.ContentNode;
import com.theladders.solid.dip.ReadOnlyArticleMetadata;
import com.theladders.solid.dip.WriteOnlyArticleMetadata;

// A SuggestedArticle is one instance of an article that has been
// recommended to a particular subscriber.

public class SuggestedArticle implements ReadOnlyArticleMetadata, WriteOnlyArticleMetadata
{
  private Integer     suggestedArticleId;
  private Integer     subscriberId;
  private Integer     suggestedArticleSourceId;
  private String      articleExternalIdentifier;
  private Integer     suggestedArticleStatusId;
  private Date        createTime;
  private Integer     creatorId;
  private Date        updateTime;
  private Integer     updaterId;
  private String      note;
  private ContentNode content;

  private Integer     STATUS_UNREAD = 1;

  public SuggestedArticle() {}

  public SuggestedArticle(Integer subscriberId,
                          String articleExternalIdentifier,
                          String note,
                          Integer adminUserId)
  {
    this.subscriberId = subscriberId;
    this.articleExternalIdentifier = articleExternalIdentifier;
    this.suggestedArticleStatusId = STATUS_UNREAD;
    this.note = note;
    this.creatorId = adminUserId;
    this.createTime = new Date(); // current date
    this.updateTime = new Date(); // current date
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSuggestedArticleId()
   */
  @Override
  @Column(name = "suggested_article_id")
  public Integer getSuggestedArticleId()
  {
    return suggestedArticleId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSuggestedArticleId(java.lang.Integer)
   */
  @Override
  public void setSuggestedArticleId(Integer suggestedArticleId)
  {
    this.suggestedArticleId = suggestedArticleId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSubscriberId()
   */
  @Override
  @Column(name = "subscriber_id")
  public Integer getSubscriberId()
  {
    return subscriberId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSubscriberId(java.lang.Integer)
   */
  @Override
  public void setSubscriberId(Integer subscriberId)
  {
    this.subscriberId = subscriberId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSuggestedArticleSourceId()
   */
  @Override
  @Column(name = "suggested_article_source_id")
  public Integer getSuggestedArticleSourceId()
  {
    return suggestedArticleSourceId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSuggestedArticleSourceId(java.lang.Integer)
   */
  @Override
  public void setSuggestedArticleSourceId(Integer suggestedArticleSourceId)
  {
    this.suggestedArticleSourceId = suggestedArticleSourceId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getArticleExternalIdentifier()
   */
  @Override
  @Column(name = "article_external_identifier")
  public String getArticleExternalIdentifier()
  {
    return articleExternalIdentifier;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setArticleExternalIdentifier(java.lang.String)
   */
  @Override
  public void setArticleExternalIdentifier(String articleExternalIdentifier)
  {
    this.articleExternalIdentifier = articleExternalIdentifier == null ? null : articleExternalIdentifier.trim();
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getSuggestedArticleStatusId()
   */
  @Override
  @Column(name = "suggested_article_status_id")
  public Integer getSuggestedArticleStatusId()
  {
    return suggestedArticleStatusId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setSuggestedArticleStatusId(java.lang.Integer)
   */
  @Override
  public void setSuggestedArticleStatusId(Integer suggestedArticleStatusId)
  {
    this.suggestedArticleStatusId = suggestedArticleStatusId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getCreateTime()
   */
  @Override
  @Column(name = "create_time")
  public Date getCreateTime()
  {
    return createTime;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setCreateTime(java.util.Date)
   */
  @Override
  public void setCreateTime(Date createTime)
  {
    this.createTime = createTime;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getCreatorId()
   */
  @Override
  @Column(name = "creator_id")
  public Integer getCreatorId()
  {
    return creatorId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setCreatorId(java.lang.Integer)
   */
  @Override
  public void setCreatorId(Integer creatorId)
  {
    this.creatorId = creatorId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getUpdateTime()
   */
  @Override
  @Column(name = "update_time")
  public Date getUpdateTime()
  {
    return updateTime;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setUpdateTime(java.util.Date)
   */
  @Override
  public void setUpdateTime(Date updateTime)
  {
    this.updateTime = updateTime;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getUpdaterId()
   */
  @Override
  @Column(name = "updater_id")
  public Integer getUpdaterId()
  {
    return updaterId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setUpdaterId(java.lang.Integer)
   */
  @Override
  public void setUpdaterId(Integer updaterId)
  {
    this.updaterId = updaterId;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#getNote()
   */
  @Override
  @Column(name = "note")
  public String getNote()
  {
    return note;
  }

  /* (non-Javadoc)
   * @see com.theladders.solid.dip.ArticleMetadata2#setNote(java.lang.String)
   */
  @Override
  public void setNote(String note)
  {
    this.note = note == null ? null : note.trim();
  }

}
