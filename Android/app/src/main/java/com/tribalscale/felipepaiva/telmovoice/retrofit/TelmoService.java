package com.tribalscale.felipepaiva.telmovoice.retrofit;

import com.tribalscale.felipepaiva.telmovoice.models.request.VoiceRequest;
import com.tribalscale.felipepaiva.telmovoice.models.response.VoiceRequestResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TelmoService {
    @POST("")
    Call<Response> pushAudio(@Path("user") String user);

    @POST("http://10.4.92.60:8080/")
    Call<VoiceRequestResponse> uploadMultipleFilesDynamic(@Body VoiceRequest files);
}
