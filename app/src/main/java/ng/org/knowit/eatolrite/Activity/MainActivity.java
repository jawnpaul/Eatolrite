package ng.org.knowit.eatolrite.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ng.org.knowit.eatolrite.Adapters.Main;
import ng.org.knowit.eatolrite.Adapters.MainAdapter;
import ng.org.knowit.eatolrite.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        String[] names = new String[Main.mains.length];
        for (int i = 0; i <names.length ; i++) {
            names[i] = Main.mains[i].getName();
        }
        int[] images = new int[Main.mains.length];
        for (int i = 0; i <images.length ; i++) {
            images[i] = Main.mains[i].getImageResourceId();
        }

        String[] moreInfo = new String[Main.mains.length];
        for (int i = 0; i <moreInfo.length ; i++) {
            moreInfo[i] = Main.mains[i].getMoreInfo();
        }

        mMainAdapter = new MainAdapter(this, names, images, moreInfo);
        recyclerView.setAdapter(mMainAdapter);

    }

}
