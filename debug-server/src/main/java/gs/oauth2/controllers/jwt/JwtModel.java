package gs.oauth2.controllers.jwt;

import leap.lang.json.JsonName;

/**
 * @author kael.
 */
public class JwtModel {
    @JsonName("jwt_token")
    protected String token;

    public JwtModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
