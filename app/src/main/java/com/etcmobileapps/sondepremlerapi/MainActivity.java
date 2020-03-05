package com.etcmobileapps.sondepremlerapi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView depremListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CustomListViewAdapter listViewAdapter[] = new CustomListViewAdapter[1];
        depremListView = (ListView) findViewById(R.id.depremList);

        final ArrayList<Repo> depremListesi = new ArrayList<>();
        final RestInterface[] restInterface = new RestInterface[1];
        restInterface[0] = ApiClient.getClient("https://turkiyedepremapi.herokuapp.com/").create(RestInterface.class);
        Call<List<Repo>> call = restInterface[0].depremListele();
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                if (response.body() != null) {


                    depremListesi.addAll(response.body());
                }


                if (depremListesi.size() > 0) {
                    listViewAdapter[0] = new CustomListViewAdapter(MainActivity.this, depremListesi);
                    depremListView.setAdapter(listViewAdapter[0]);
                }

                depremListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        // Herhangi bir depreme tıklandığında çalışacak olan bölüm
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Veri çekilemedi.", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
