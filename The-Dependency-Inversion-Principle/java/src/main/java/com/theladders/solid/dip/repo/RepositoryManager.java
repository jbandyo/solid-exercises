package com.theladders.solid.dip.repo;

import com.theladders.solid.dip.ArticleRepository;
import com.theladders.solid.dip.ContentNode;

public class RepositoryManager implements ArticleRepository
{
  public ContentNode getNodeByUuid(String id)
  {
    ContentNode node = new ContentNode();

    node.addProperty("uuid", id);

    return node;
  }

  @Override
  public void addNode(String articleExternalIdentifier)
  {
    // TODO Auto-generated method stub
    
  }
}
