package gs.oauth2;

import gs.oauth2.models.Client;
import gs.oauth2.models.User;
import leap.core.annotation.Inject;
import leap.core.security.SEC;
import leap.oauth2.as.OAuth2AuthzServerConfigurator;
import leap.web.App;
import leap.web.api.Apis;
import leap.web.config.WebConfigurator;

public class Global extends App {

    protected @Inject Apis apis;
    protected @Inject OAuth2AuthzServerConfigurator asc;

    @Override
    protected void configure(WebConfigurator c) {
        //configure oauth2 server.
        asc.enable().useJdbcStore();

        //init data
        initData();
    }

    protected void initData() {

        //creates 3 users
        if(User.count() == 0) {
            for(int i=1;i<=3;i++) {
                User user = new User();
                user.setName("user" + i);
                user.setPassword(SEC.encodePassword("pass" + 1));
                user.create();
            }
        }

        //creates 3 clients
        if(Client.count() == 0) {

            for(int i=0;i<=3;i++) {
                Client client = new Client();
                client.setId("client" + i);
                client.setSecret("secret" + i);
                client.setRedirectUriPattern("*");
                client.setLogoutUriPattern("*");
                client.create();
            }

        }

    }
}