package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

public class Analysis_results extends AppCompatActivity {
    DocumentReference docRef;
    private String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_results);

        key = getIntent().getStringExtra("HistKey");
        docRef = FirebaseFirestore.getInstance().collection("imgStore").document(key);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot> () {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        Log.i("Firestore Fetch:", "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.w("Firestore Fetch:", "No such document");
                    }
                } else {
                    Log.e("Firestore Fetch:", "get failed with " +task.getException());
                }
            }
        });

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
