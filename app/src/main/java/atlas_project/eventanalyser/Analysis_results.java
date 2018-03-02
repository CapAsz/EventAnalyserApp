package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Analysis_results extends AppCompatActivity {
    DocumentReference docRef;
    private String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_results);
        FirebaseApp.initializeApp(this);
        FirebaseFirestore histograms = FirebaseFirestore.getInstance();

        key = getIntent().getStringExtra("HistKey");
        //docRef = histograms.collection("imgStore").document(key);

//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot> () {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document != null && document.exists()) {
//                        System.out.print("DocumentSnapshot data: " + document.getData());
//                    } else {
//                        System.out.print("No such document");
//                    }
//                } else {
//                    System.out.print("get failed with " +task.getException());
//                }
//            }
//        });

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(Analysis_results.this, Analysis_main.class);
                startActivity(goToTab);
            }
        });
    }


}
