package edu.psu.jbr5410.paramount475;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class RoomActivity extends AppCompatActivity {

    private int day, month, year, dayOfWeek, partyPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Intent intent = getIntent();
        day = intent.getIntExtra("day", -1);
        month = intent.getIntExtra("month", -1);
        year = intent.getIntExtra("year", -1);
        dayOfWeek = intent.getIntExtra("dayOfWeek",-1);
        partyPackage = intent.getIntExtra("package", -1);



        Spinner spinner = findViewById(R.id.spinner_rooms);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String room = spinner.getSelectedItem().toString();
                TextView description = findViewById(R.id.text_roomDescription);
                switch(room) {
                    case "Main Gym": description.setText("Our main gym provides entertainment for all ages. Your party helper will run your party however you would like. Chose between obstacle courses, trampolines, pit activities, age appropriate games, relay races, music and free play, or do it all!"); break;
                    case "Kid Maze": description.setText("The Kidmazium is a multi-level climbing and play structure for children aged up to 12 years. It includes nets, tunnels and slides for climbing, crawling, sliding fun. There’s even a bouncy house inside! Don’t forget your socks!"); break;
                    case "Rockwall": description.setText("Our rockwall is a great place to learn a new skill or improve your technique while having fun with friends, Free climbing time, races, games and activities with your belay certified party helper."); break;
                    case "Preschool Room": description.setText("Our preschool gym is the perfect size for your preschooler and friends! The party will include age appropriate structured games, mini trampoline, ball pit, parachute activities, music and free play."); break;
                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    public void submit(View view) {
        Intent intent = new Intent(this, TimeslotActivity.class);

        Spinner roomSpinner = findViewById(R.id.spinner_rooms);
        String room = roomSpinner.getSelectedItem().toString();
        String[] rooms = {room};

        intent.putExtra("day", day);
        intent.putExtra("month", month);
        intent.putExtra("year", year);
        intent.putExtra("dayOfWeek", dayOfWeek);
        intent.putExtra("package", partyPackage);
        intent.putExtra("rooms", rooms);

        startActivity(intent);
    }

    @Override
    public void onRestoreInstanceState(Bundle saved) {
        super.onRestoreInstanceState(saved);

        day = saved.getInt("day");
        month = saved.getInt("month");
        year = saved.getInt("year" );
        dayOfWeek = saved.getInt("dayOfWeek");
        partyPackage = saved.getInt("package");
    }

    @Override
    public void onSaveInstanceState(Bundle saved) {
        saved.putInt("day", day);
        saved.putInt("month", month);
        saved.putInt("year", year);
        saved.putInt("dayOfWeek", dayOfWeek);
        saved.putInt("package", partyPackage);

        super.onSaveInstanceState(saved);
    }


}
