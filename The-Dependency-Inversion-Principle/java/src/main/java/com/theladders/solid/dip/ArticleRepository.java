package com.theladders.solid.dip;

public interface ArticleRepository
{

  ContentNode getNodeByUuid(String articleExternalIdentifier);

  void addNode(String articleExternalIdentifier);

}
