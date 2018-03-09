package atlas_project.eventanalyser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Analysis_results extends AppCompatActivity {
    private String key = "";                               //key of values to fetch histograms
    HashMap<String, Drawable> hist_list = new HashMap<>(); //hashmap of histograms and labels
    int dis_width;                                         //device screen width

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_results);

        //get size of screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        dis_width = displayMetrics.widthPixels;

        //retrieve key and fetch histograms
        key = getIntent().getStringExtra("HistKey");
        Log.i("Fetch Key:", key);
        DocumentReference docRef = FirebaseFirestore.getInstance().collection("imgStore").document(key);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot> () {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        Map<String, Object> histograms = document.getData();
                        Iterator histStore = histograms.entrySet().iterator();
                        while (histStore.hasNext()){
                            Map.Entry pair = (Map.Entry)histStore.next();
                            String histogramStr = String.valueOf(pair.getKey()); //get histogram title
                            Log.i("Firestore Fetch Key:", "histogram name: " + histogramStr);
                            byte[] decodedStr = Base64.decode(String.valueOf(pair.getValue()), Base64.DEFAULT);
                            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedStr, 0, decodedStr.length);
                            Drawable histogramImg = new BitmapDrawable(getResources(), decodedByte); //convert bitmap to Drawable
                            histStore.remove();
                            hist_list.put(histogramStr, histogramImg); //add histogram to hashmap with title as key
                        }
                    } else {
                        Log.w("Firestore Fetch:", "No such document");
                    }
                } else {
                    Log.e("Firestore Fetch:", "get failed with " +task.getException());
                }
                histogramsLayout(); //show histograms in side-scrolling grid layout
            }
        });

        //button to return to choosing values to analyse
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Analysis_results.this, Analysis_main.class);
                startActivity(goToTab);
            }
        });
    }

    /**
     * Method for arranging histograms and their labels in a side-scrolling grid layout
     */
    public void histogramsLayout() {
        GridLayout ib_layout = findViewById(R.id.ib_layout);
        ib_layout.setColumnCount(hist_list.size());
        //arrange histograms
        for(String key : hist_list.keySet()) {
            Drawable hist = hist_list.get(key);
            Drawable hist_resized = resize(hist, dis_width);
            ImageButton ib = new ImageButton(this);
            ib.setImageDrawable(hist_resized);
            ib.setContentDescription(key);
            // Adds the ImageButton to the layout
            ib_layout.addView(ib);
        }
        //arrange labels
        for (String key : hist_list.keySet()) {
            Scanner s = new Scanner(key);
            s.useDelimiter(".gif");
            TextView tv = new TextView(this);
            tv.setText(s.next());
            tv.setTextSize(18);
            tv.setWidth(dis_width);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setTextColor(getResources().getColor(R.color.colorButtonText));
            ib_layout.addView(tv);
        }
    }

    /**
     * Method for resizing Drawable elements.
     * @param image histogram to resize
     * @param width width to resize to
     * @return resized histogram as Drawable
     */
    private Drawable resize(Drawable image, int width) {
        Bitmap bitmap = ((BitmapDrawable)image).getBitmap();
        int height = bitmap.getHeight()*width/bitmap.getWidth();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(bitmap, width, height, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }
}