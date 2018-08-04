package com.example.archek.devsteam;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.archek.devsteam.Network.RestApi;
import com.example.archek.devsteam.Network.UnsplashObjectResponse;
import com.example.archek.devsteam.Network.UnsplashObjectsListResponse;
import com.example.archek.devsteam.Network.UnsplashService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener{

    private static final String TAG = "33__";
    private RecyclerView rvMain;
    private PictureAdapter adapter = new PictureAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle( R.string.pictures );
        toolbar.inflateMenu( R.menu.menu );
        toolbar.setOnMenuItemClickListener( this );
        rvMain = findViewById( R.id.rvMain );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this );
        rvMain.setLayoutManager( layoutManager );
        rvMain.setAdapter( adapter );
        UnsplashService service = RestApi.creteService( UnsplashService.class );

        Call<UnsplashObjectsListResponse> call = service.getPictures( 10,544 );
        Callback<UnsplashObjectsListResponse> callback = new Callback<UnsplashObjectsListResponse>(){
            @Override
            public void onResponse(Call <UnsplashObjectsListResponse> call, Response <UnsplashObjectsListResponse> response) {
                Log.d(TAG, "onResponse");
            }

            @Override
            public void onFailure(Call <UnsplashObjectsListResponse> call, Throwable t) {
                Log.d(TAG,"onFailure");
            }
        } ;
        call.enqueue( callback );
//        gsonSandbox();
//        fillWithFakeData();
    }
//    public void gsonSandbox(){
//        Gson gson = new GsonBuilder()
//                .setPrettyPrinting()
//                .create();
//        UnsplashObjectResponse prePicture = new UnsplashObjectResponse( " Sonny", "Johny", "https://images.unsplash.com/5/unsplash-kitsune-4.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9&s=50827fd8476bfdffe6e04bc9ae0b8c02" );
//        String jsonPrePicture = gson.toJson( prePicture );
//        Log.d(TAG, jsonPrePicture);
//    }


//    public void onViewCreated(@Nullable MainActivity view, @Nullable Bundle savedInstanceState){
//        setupToolbar(view);
//        setupRecyclerView(view);
//
//        fillWithFakeData();
//
//
//
//    }

//    private void fillWithFakeData() {
//        List<UnsplashObjectResponse> fakeList = new ArrayList <>(  );
//        for(int i = 0; i< 20;i++) {
//            UnsplashObjectResponse prePicture;
//            if (i % 3 == 0) {
//                prePicture = new UnsplashObjectResponse( " Sonny", "Johny", "https://images.unsplash.com/5/unsplash-kitsune-4.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9&s=50827fd8476bfdffe6e04bc9ae0b8c02" );
//
//            } else if (i % 3 == 1) {
//                prePicture = new UnsplashObjectResponse( "asd", "fds", "https://www.giantbomb.com/api/image/scale_small/707238-bass_avenger.jpg" );
//            } else {
//                prePicture = new UnsplashObjectResponse( "111", "asd", "https://images.unsplash.com/example.jpg?q=75&fm=jpg&w=400&fit=max&&ixid=123123123" );
//            }
//            fakeList.add( prePicture );
//
//        }
//        adapter.addAll( fakeList );
//    }

//    private void setupRecyclerView(View view) {
//        rvMain = view.findViewById( R.id.rvMain );
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this );
//        rvMain.setLayoutManager( layoutManager );
//        rvMain.setAdapter( adapter );
//
//    }
//
//    public void setupToolbar(View view) {
//        Toolbar toolbar = view.findViewById( R.id.toolbar );
//        toolbar.setTitle( R.string.pictures );
//        toolbar.inflateMenu( R.menu.menu );
//        toolbar.setOnMenuItemClickListener( this );
//    }
    
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId() == R.id.refresh){
            Toast.makeText( getApplicationContext(),R.string.refresh,Toast.LENGTH_SHORT ).show();
            return true;
        }
        return false;
    }
//    private void setupToolbar(View view) {
//        android.support.v7.widget.Toolbar toolbar = view.findViewById(R.id.toolbar);
//        toolbar.setTitle(R.string.pictures);
//        toolbar.inflateMenu(R.menu.menu);
//        setSupportActionBar(toolbar);
//    }

}
