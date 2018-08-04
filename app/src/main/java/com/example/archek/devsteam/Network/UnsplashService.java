package com.example.archek.devsteam.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UnsplashService {

    @GET("pictures/?api_key=d71c825b3d8bfb52fccb7f1ebce14b52dbbcb1243ee02d58c82dc5725940b90b&format=json&field_list=name,author")
    Call<UnsplashObjectsListResponse> getPictures(@Query( "limit" ) int limit,@Query( "offset" ) int offset );

    @GET("picture/{guid}/?api_key=0a80e1bbb07356d3658e6413b066b13824764567&format=json&field_list=description")
    Call<UnsplashObjectsListResponse> getPictureDetails(@Path("guid") String guid);

}
