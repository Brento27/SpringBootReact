package com.brent.app.ws.userservice;

import com.brent.app.ws.ui.models.request.UserDetailsRequestModel;
import com.brent.app.ws.ui.models.response.UserRest;

public interface UserService {
UserRest createUser(UserDetailsRequestModel userDetails);
}
