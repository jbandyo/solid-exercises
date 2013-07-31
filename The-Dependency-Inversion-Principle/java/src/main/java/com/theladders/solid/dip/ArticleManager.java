package com.theladders.solid.dip;

import java.util.List;

import com.theladders.solid.dip.db.SuggestedArticle;

public interface ArticleManager
{
  /**
   * Get metadata for a list of all active suggested articles for a given subscriber.
   *
   *   Sorted reverse chronological by time recommended
   *
   * It also gets the content of the actual articles from the CMS and stores it in
   * the SuggestedArticle object.
   *
   * @param subscriberId
   *          ID of this subscriber
   * @return List of metadata for all suggested articles whose status is either New or Viewed
   */
  public List<ReadOnlyArticleMetadata> getArticleMetadataListBySubscriber(Integer subscriberId);

  /**
   * Get Content for a given External Identifier.
   * @param   articleExternalIdentifier
   * @return  ContentNode object
   */
  public ContentNode getArticleContent(String articleExternalIdentifier);

  /**
   * Add a SuggestedArticle to the database.
   *
   * @param suggestedArticle
   */
  public void addArticle(Integer subscriberId,
                         Integer creatorId,
                         String note,
                         ContentNode content);

  /**
   * Update the note of the Suggested Article(id)
   *  with the note passed in.
   *
   */
  public void updateNote(Integer articleId, String note);

  /**
   * Mark as deleted the Suggested Article(id)
   *
   */
  public void markRecomDeleted(Integer id);


}
