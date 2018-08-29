package com.example.tarrito.tarea_4.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import com.example.tarrito.tarea_4.R;
import com.example.tarrito.tarea_4.adapters.MyAdapter;
import com.example.tarrito.tarea_4.models.Alumno;

import java.util.List;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Alumno>> {

    private GridView gridView;
    private MyAdapter adapter;

    private Realm realm;
    private RealmResults<Alumno> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        gridView = (GridView) findViewById(R.id.gridView);

        alumnos = getAllAlumno();
        alumnos.addChangeListener(this);

        adapter = new MyAdapter(alumnos, R.layout.grid_item_view, this);

        gridView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add:
                addPeople();
                return true;
            case R.id.item_delete:
                removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private RealmResults<Alumno> getAllAlumno() {
        return realm.where(Alumno.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                Alumno p1 = new Alumno("123456789", "alejandro", "peres", 23, "ing algo", 1234, "primero");
                Alumno p2 = new Alumno("123456789", "jano", "pores", 23, "ing algi", 1234, "segundo");
                Alumno p3 = new Alumno("123456789", "alex", "peros", 23, "ing algu", 1234, "stercero");


                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);

                alumnos = getAllAlumno();
            }
        });
    }
}