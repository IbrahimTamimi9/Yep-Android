package catchla.yep.util;

import org.mariotaku.restfu.annotation.method.PATCH;
import org.mariotaku.restfu.annotation.method.POST;
import org.mariotaku.restfu.annotation.method.PUT;
import org.mariotaku.restfu.annotation.param.Body;
import org.mariotaku.restfu.annotation.param.Form;
import org.mariotaku.restfu.http.BodyType;

import catchla.yep.model.Client;
import catchla.yep.model.CreateRegistrationResult;
import catchla.yep.model.ProfileUpdate;
import catchla.yep.model.UpdateRegistrationResult;
import catchla.yep.model.User;

/**
 * Created by mariotaku on 15/5/12.
 */
public interface YepAPI {

    @POST("/v1/registration/create")
    @Body(BodyType.FORM)
    CreateRegistrationResult createRegistration(@Form("mobile") String mobile,
                                                @Form("phone_code") String phoneCode,
                                                @Form("nickname") String nickname,
                                                @Form("longitude") double longitude,
                                                @Form("latitude") double latitude) throws YepException;

    @PUT("/v1/registration/update")
    @Body(BodyType.FORM)
    UpdateRegistrationResult updateRegistration(@Form("mobile") String mobile,
                                                @Form("phone_code") String phoneCode,
                                                @Form("token") String token,
                                                @Form("client") Client client,
                                                @Form("expiring") long expiringInseconds) throws YepException;

    @PATCH("/v1/user")
    User updateProfile(@Form ProfileUpdate profileUpdate) throws YepException;

}

