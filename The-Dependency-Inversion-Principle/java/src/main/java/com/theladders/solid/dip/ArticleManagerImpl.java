package com.theladders.solid.dip;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

import com.theladders.solid.dip.ArticleMetadataProvider.ArticleOrderField;
import com.theladders.solid.dip.ArticleMetadataProvider.ArticleStatus;


public class ArticleManagerImpl implements ArticleManager
{
  private ImageManager imageManager;
  private ArticleMetadataProvider  articleMetadataProvider;
  private ArticleRepository  articleRepository;

  public ArticleManagerImpl(ImageManager imageManager,
                            ArticleMetadataProvider suggestedArticleMetadataProvider,
                            ArticleRepository articleRepository)
  {
    this.imageManager = imageManager;
    this.articleMetadataProvider = suggestedArticleMetadataProvider;
    this.articleRepository = articleRepository;
  }

  @Override
  public List<ReadOnlyArticleMetadata> getArticleMetadataListBySubscriber(Integer subscriberId)
                                                                      //EnumSet<ArticleStatus> flags,
                                                                      //ArticleOrderField orderByFirst,
                                                                      //ArticleOrderField orderBySecond)
  {
    EnumSet<ArticleStatus> flags = EnumSet.of(ArticleStatus.NEW, ArticleStatus.VIEWED);
    return articleMetadataProvider.getArticlesbySubscriber(subscriberId,
                                                           flags,
                                                           ArticleOrderField.CREATE_TIME,
                                                           ArticleOrderField.DESC);
  }
  
  @Override
  public ContentNode getArticleContent(String articleExternalIdentifier)
  {
    ContentNode content = articleRepository.getNodeByUuid(articleExternalIdentifier);
    if (content != null && ContentUtils.isPublishedAndEnabled(content))
    {
      // Override miniImagePath
      overrideMiniImagePath(content);
    }
    return content;
  }

  private void overrideMiniImagePath(ContentNode node)
  {
    String path = (String) node.getProperty("miniImagePath");

    if (path == null || path.length() == 0)
    {
      String category = (String) node.getProperty("primaryTopic");
      node.addProperty("miniImagePath", imageManager.getImageFilePath(category));
    }
  }

  @Override
  public void addArticle(Integer subscriberId,
                         Integer creatorId,
                         String note,
                         ContentNode content)
  {
    String externalId = UUID.randomUUID().toString();
    articleMetadataProvider.createArticle(subscriberId, externalId, note, creatorId);
    
    articleRepository.addNode(externalId);
  }

  @Override
  public void updateNote(Integer articleId,
                         String note)
  {
    articleMetadataProvider.updateNote(articleId, note);
  }

  @Override
  public void markRecomDeleted(Integer articleId)
  {
    articleMetadataProvider.markRecomDeleted(articleId);
  }

}
