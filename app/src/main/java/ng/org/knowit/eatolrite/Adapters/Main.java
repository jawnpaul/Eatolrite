package ng.org.knowit.eatolrite.Adapters;

/**
 * Created by john on 12/14/17.
 */
import java.io.Serializable;

import ng.org.knowit.eatolrite.R;

public class Main implements Serializable{
    private String name;
    private int imageResourceId;
    private String moreInfo;

    public static final Main[] mains = {
            new Main("BMI", R.drawable.bmi, "I am BMI"),
            new Main("Store", R.drawable.store, "Iam store"),
            new Main("Graph", R.drawable.graph, "Iam graph")
    };

    public Main(String name, int imageResourceId, String moreInfo){
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.moreInfo = moreInfo;

    }



    public String getName(){
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getMoreInfo() {
        return moreInfo;
    }
}
