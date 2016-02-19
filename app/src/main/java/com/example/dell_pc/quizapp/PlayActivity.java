package com.example.dell_pc.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by DELL-PC on 2/19/2016.
 */
public class PlayActivity extends AppCompatActivity{
    public static int numCorrect = 0;
  //  public static PlayActivity activity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    //    activity = this;
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, new QuestionOne())
                .addToBackStack(null)
                .commit();
    }

  //  @Override
  /*  public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        getMenuInflater()

        return true;
    }
*/
   /* public void  reset() {
        numCorrect = 0;
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }*/
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
}
