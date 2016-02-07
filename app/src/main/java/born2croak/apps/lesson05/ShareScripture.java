package born2croak.apps.lesson05;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ShareScripture extends AppCompatActivity {

    private String book;
    private String chapter;
    private String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_scripture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        book = "";
        chapter = "";
        verse = "";
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share_scripture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onShareButtonClick(View v) {
        EditText e1 = (EditText)findViewById(R.id.bookInput);
        EditText e2 = (EditText)findViewById(R.id.chapterInput);
        EditText e3 = (EditText)findViewById(R.id.verseInput);

        book = e1.getText().toString();
        chapter = e2.getText().toString();
        verse = e3.getText().toString();

        if (!book.equals("") && !chapter.equals("") || !verse.equals("")) {
            passToDisplay();
        }
    }

    public void passToDisplay() {
        Intent intentBundle = new Intent(ShareScripture.this, DisplayScripture.class);
        Bundle bundle = new Bundle();
        bundle.putString("book", book);
        bundle.putString("chapter", chapter);
        bundle.putString("verse", verse);
        intentBundle.putExtras(bundle);
        startActivity(intentBundle);
    }
}
