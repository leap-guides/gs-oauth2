package gs.oauth2.controllers.jwt;

import leap.core.BeanFactory;
import leap.core.annotation.Inject;
import leap.core.security.annotation.AllowAnonymous;
import leap.core.security.token.jwt.JWT;
import leap.core.security.token.jwt.JwtSigner;
import leap.core.security.token.jwt.RsaSigner;
import leap.oauth2.as.OAuth2AuthzServerConfig;
import leap.web.annotation.Path;
import leap.web.annotation.http.POST;
import leap.web.api.mvc.ApiController;
import leap.web.api.mvc.ApiResponse;
import leap.web.api.mvc.params.Partial;

import java.security.interfaces.RSAPrivateKey;
import java.util.Map;

/**
 * @author kael.
 */
@Path("/oauth2/jwt")
@AllowAnonymous
public class JwtController extends ApiController {
    
    protected JwtSigner signer;
    protected @Inject OAuth2AuthzServerConfig config;

    @POST
    public ApiResponse<JwtModel> createJwt(Partial partial){
        if(null == signer){
            signer = new RsaSigner((RSAPrivateKey) config.getPrivateKey());
        }
        Map<String, Object> claims = partial.getProperties();
        if(!claims.containsKey(JWT.CLAIM_AUDIENCE)){
            claims.put(JWT.CLAIM_AUDIENCE,"1234567890ABCD");
        }
        if(!claims.containsKey("username")){
            claims.put("username","testuser");
        }
        if(!claims.containsKey("user_id")){
            claims.put("user_id",claims.get(JWT.CLAIM_AUDIENCE));
        }
        String jwt = signer.sign(claims);
        return ApiResponse.ok(new JwtModel(jwt));
    }

}
