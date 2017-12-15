package ng.org.knowit.eatolrite.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ng.org.knowit.eatolrite.Activity.CalculateBMI;
import ng.org.knowit.eatolrite.R;

import static ng.org.knowit.eatolrite.Adapters.Main.mains;

/**
 * Created by john on 12/14/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private Context context;
    private String[] mainNames;
    private int[] imageIds;
    private String[] moreInfo;

    public MainAdapter(Context context, String[] mainNames, int[] imageIds, String[] moreInfo){
        this.context = context;
        this.mainNames = mainNames;
        this.imageIds = imageIds;
        this.moreInfo = moreInfo;
    }

    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.main_card,parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        CardView cardView = holder.cardview;
        ImageView imageView = cardView.findViewById(R.id.info_main_img);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(mainNames[position]);
        TextView textView = cardView.findViewById(R.id.info_main_name);
        textView.setText(mainNames[position]);
        TextView textView1 = cardView.findViewById(R.id.info_main);
        textView1.setText(moreInfo[position]);

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent  = new Intent(context, CalculateBMI.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mains.length;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private CardView cardview;

        public CustomViewHolder(CardView v) {

            super(v);
            cardview = v;
        }
    }
}
