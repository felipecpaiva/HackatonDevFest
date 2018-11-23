package com.tribalscale.felipepaiva.telmovoice.retrofit;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TelmoService {
    @POST("")
    Call<Response> pushAudio(@Path("user") String user);

    @POST("https://telmo.pagekite.me/")
    Call<ResponseBody> uploadMultipleFilesDynamic(@Body VoiceRequest files);
}
