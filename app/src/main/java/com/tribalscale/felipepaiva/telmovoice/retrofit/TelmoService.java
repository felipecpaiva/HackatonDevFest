package com.tribalscale.felipepaiva.telmovoice.retrofit;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface TelmoService {
    @POST("")
    Call<Response> pushAudio(@Path("user") String user);

    @Multipart
    @POST("")
    Call<ResponseBody> uploadMultipleFilesDynamic(
            @Part MultipartBody.Part files);
}
