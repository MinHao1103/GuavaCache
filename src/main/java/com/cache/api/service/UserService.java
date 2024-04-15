package com.cache.api.service;

import com.cache.api.deledgate.UserDeledgate;
import com.cache.api.dto.LoginInfo;
import com.cache.api.dto.ReqLogin;
import com.cache.api.utils.CommonHttpResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;


@Path("/User")
public class UserService {
    private static final String TAG = "UserService";

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CommonHttpResult<LoginInfo> login(ReqLogin reqLogin) {
        return UserDeledgate.login(reqLogin);
    }

    @GET
    @Path("/getUserAccount")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CommonHttpResult<String> getUserAccount(@QueryParam("token") String token) {
        return UserDeledgate.getUserAccount(token);
    }

    @GET
    @Path("/printAllLoginTokens")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CommonHttpResult<Map<String, LoginInfo>> printAllLoginTokens() {
        return UserDeledgate.printAllLoginTokens();
    }

}
