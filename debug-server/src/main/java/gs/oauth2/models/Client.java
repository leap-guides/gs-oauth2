package gs.oauth2.models;

import leap.orm.annotation.Column;
import leap.orm.annotation.Id;
import leap.orm.annotation.Table;
import leap.orm.model.Model;

@Table("oauth2_client")
public class Client extends Model {

    @Id(generate=false)
    protected String id;

    @Column
    protected String secret;

    @Column
    protected String redirectUriPattern;

    @Column
    protected String logoutUriPattern;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRedirectUriPattern() {
        return redirectUriPattern;
    }

    public void setRedirectUriPattern(String redirectUriPattern) {
        this.redirectUriPattern = redirectUriPattern;
    }

    public String getLogoutUriPattern() {
        return logoutUriPattern;
    }

    public void setLogoutUriPattern(String logoutUriPattern) {
        this.logoutUriPattern = logoutUriPattern;
    }
}
