package gs.oauth2.controllers.restd;

import gs.oauth2.models.User;
import leap.core.security.SEC;
import leap.web.annotation.http.POST;
import leap.web.api.mvc.ApiResponse;
import leap.web.api.mvc.ModelController;

public class UserController extends ModelController<User> {

    @POST
    public ApiResponse createUser(User user) {
        user.setPassword(SEC.encodePassword(user.getPassword()));
        return createAndReturn(user.fields());
    }

}
