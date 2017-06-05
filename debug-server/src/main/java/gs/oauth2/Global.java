package gs.oauth2;

import leap.core.annotation.Inject;
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

        //apis.add("debug", "/api").enableRestd();
    }
}