package ylix9g.blog.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

  private final String authority;

  private final boolean isRole;

  public GrantedAuthorityImpl(String authority, boolean isRole) {
    this.authority = authority;
    this.isRole = isRole;
  }

  @Override
  public String getAuthority() {
    return (isRole ? "ROLE_" : "") + authority.toUpperCase();
  }
}
