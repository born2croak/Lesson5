package born2croak.apps.lesson05;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DisplayScripture extends AppCompatActivity {

    private String book;
    private String chapter;
    private String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        book = "";
        chapter = "";
        verse = "";

        loadScripture();
        displayScripture();
    }

    public void loadScripture () {
        Intent intentExtras = getIntent();
        Bundle extrasBundle = intentExtras.getExtras();

        if (!extrasBundle.isEmpty()) {
            boolean hasBook = extrasBundle.containsKey("book");
            boolean hasChapter = extrasBundle.containsKey("chapter");
            boolean hasVerse = extrasBundle.containsKey("verse");

            if (hasBook == true && hasChapter == true && hasVerse == true) {
                book = extrasBundle.getString("book");
                chapter = extrasBundle.getString("chapter");
                verse = extrasBundle.getString("verse");
            }
        }
    }

    public void displayScripture () {
        TextView t1 = (TextView)findViewById(R.id.scriptureView);
        t1.setText(book + " " + chapter + ":" + verse);
    }

}
