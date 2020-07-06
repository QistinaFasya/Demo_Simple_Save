package sg.edu.rp.c346.id18015170.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //String msg = "No greetings!";

        // obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // retrieve the saved data with the key from the SharedPreference object
        String msg = prefs.getString("greetings", "No greetings!");
        Toast toast  = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    protected void onPause(){
        //save app when app is no longer (fully) visible
        super.onPause();
        // obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // obtain instance of SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // add key-value pair
        prefEdit.putString("greetings", "Hello!");
        // commit to save changes
        prefEdit.commit();
    }

}
