package sg.edu.rp.c346.id20032316.democontextmenutranslation2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.tvTranslation);
        tvTranslatedText2 = findViewById(R.id.tvTranslation2);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (v == tvTranslatedText) {
            wordClicked = "1st";
        } else if (v == tvTranslatedText2) {
            wordClicked = "2nd";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("1st")) {
            if (item.getItemId() == R.id.EnglishSelected) {
                tvTranslatedText.setText("Hello");
            } else if (item.getItemId() == R.id.ItalianSelected) {
                tvTranslatedText.setText("Ciao");
            }
        } else if (wordClicked.equalsIgnoreCase("2nd")) {
            if (item.getItemId() == R.id.EnglishSelected) {
                tvTranslatedText2.setText("Bye");
            } else if (item.getItemId() == R.id.ItalianSelected) {
                tvTranslatedText2.setText("Addio");
            }
        }
        return super.onContextItemSelected(item);
    }
}
