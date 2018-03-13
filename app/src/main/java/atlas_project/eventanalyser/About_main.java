package atlas_project.eventanalyser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class About_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_main);

        //link to website
//        String html1 = "<a href=\"http://www.---">Google</a>";
//        Spanned result1;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            result1 = Html.fromHtml(html1,Html.FROM_HTML_MODE_LEGACY);
//        } else {
//            result1 = Html.fromHtml(html1);
//        }
//        TextView link1 = findViewById(R.id.Link1);
//        link1.setText(result1);
//        link1. setMovementMethod(LinkMovementMethod.getInstance());

        //link to ATLAS open data
        String html2 = "<a href=\"http://opendata.cern.ch/docs/about-atlas\">opendata.cern.ch/docs/about-atlas</a>";
        Spanned result2;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result2 = Html.fromHtml(html2,Html.FROM_HTML_MODE_LEGACY);
        } else {
            result2 = Html.fromHtml(html2);
        }
        TextView link2 = findViewById(R.id.Link2);
        link2.setText(result2);
        link2. setMovementMethod(LinkMovementMethod.getInstance());

        ImageButton home = findViewById(R.id.home10);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTab = new Intent(About_main.this, Menu.class);
                startActivity(goToTab);

            }
        });
    }
}
