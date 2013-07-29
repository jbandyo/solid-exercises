package com.theladders.solid.lsp;

import java.util.HashMap;

public class Environment extends HashMap<Object, Object>
{
  public static final String KEY_EMAIL_DOMAIN = "emaildomain";

  public Environment()
  {
    super();
  }

  public Environment(int initialCapacity)
  {
    super(initialCapacity);
  }

  public Environment(int initialCapacity, float loadFactor)
  {
    super(initialCapacity, loadFactor);
  }

  /**
   * Convenience method that returns the admin email address for this ladder.
   *
   * @return email address or "" if either the user or domain is not defined
   */

  public String getAdminEmail()
  {
    String user = getString("admin");
    String domain = getString(KEY_EMAIL_DOMAIN);

    return user.length() > 0 && domain.length() > 0 ? user + "@" + domain : "";
  }

  public String getString(String key)
  {
    Object val = get(key);
    return (val != null) ? val.toString().trim() : "";
  }
}
