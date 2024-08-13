package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    SQLite db;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         db = new SQLite(MainActivity.this);

        preferences = getSharedPreferences("Database" , MODE_PRIVATE);
        boolean flag= preferences.getBoolean("check",false);

        if (flag==false){

            Enterdata();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("check",true);
            editor.commit();

        }

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        ViewPagerMessengerAdepter adepter = new ViewPagerMessengerAdepter(getSupportFragmentManager());
        viewPager.setAdapter(adepter);
        tab.setupWithViewPager(viewPager);

    }

    private byte[] imageConverter(Drawable image ){

        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] imageBytes = stream.toByteArray();

        return imageBytes;

    }

    private   void Enterdata(){
        Datamode d1= new Datamode("Air Field", imageConverter(getResources().getDrawable(R.drawable.sign1)));
        db.save(d1);
        Datamode d2= new Datamode("Carriageway Narrow", imageConverter(getResources().getDrawable(R.drawable.sign2)));
        db.save(d2);
        Datamode d3= new Datamode("Cattle Crossing", imageConverter(getResources().getDrawable(R.drawable.sign3)));
        db.save(d3);
        Datamode d4= new Datamode("Children Crossing", imageConverter(getResources().getDrawable(R.drawable.sign4)));
        db.save(d4);
        Datamode d5= new Datamode("Cyclists", imageConverter(getResources().getDrawable(R.drawable.sign5)));
        db.save(d5);
        Datamode d6= new Datamode("Dangerous Descent", imageConverter(getResources().getDrawable(R.drawable.sign6)));
        db.save(d6);
        Datamode d7= new Datamode("Double Bend to Left", imageConverter(getResources().getDrawable(R.drawable.sign7)));
        db.save(d7);
        Datamode d8= new Datamode("Double Bend to Right", imageConverter(getResources().getDrawable(R.drawable.sign8)));
        db.save(d8);
        Datamode d9= new Datamode("Falling Rocks", imageConverter(getResources().getDrawable(R.drawable.sign9)));
        db.save(d9);
        Datamode d10= new Datamode("Left Bend", imageConverter(getResources().getDrawable(R.drawable.sign10)));
        db.save(d10);
        Datamode d11= new Datamode("Level Crossing with Gate", imageConverter(getResources().getDrawable(R.drawable.sign11)));
        db.save(d11);
        Datamode d12= new Datamode("Level Crossing without Gate", imageConverter(getResources().getDrawable(R.drawable.sign12)));
        db.save(d12);
        Datamode d13= new Datamode("Lights Signals", imageConverter(getResources().getDrawable(R.drawable.sign13)));
        db.save(d13);
        Datamode d14= new Datamode("Lose Gravel", imageConverter(getResources().getDrawable(R.drawable.sign14)));
        db.save(d14);
        Datamode d15= new Datamode("Minor Cross Road", imageConverter(getResources().getDrawable(R.drawable.sign15)));
        db.save(d15);
        Datamode d16= new Datamode("Minor Cross Road from Left", imageConverter(getResources().getDrawable(R.drawable.sign16)));
        db.save(d16);
        Datamode d17= new Datamode("Minor Cross Road from Right", imageConverter(getResources().getDrawable(R.drawable.sign17)));
        db.save(d17);
        Datamode d18= new Datamode("Minor Cross Road Joining from Left", imageConverter(getResources().getDrawable(R.drawable.sign18)));
        db.save(d18);
        Datamode d19= new Datamode("Minor Cross Road Joining from Right", imageConverter(getResources().getDrawable(R.drawable.sign19)));
        db.save(d19);
        Datamode d20= new Datamode("Minor Cross Road Joining from Left & Right Respectively", imageConverter(getResources().getDrawable(R.drawable.sign20)));
        db.save(d20);
        Datamode d21= new Datamode("Minor Road on Left", imageConverter(getResources().getDrawable(R.drawable.sign21)));
        db.save(d21);
        Datamode d22= new Datamode("Minor Road on Right", imageConverter(getResources().getDrawable(R.drawable.sign22)));
        db.save(d22);
        Datamode d23= new Datamode("Other Dangers", imageConverter(getResources().getDrawable(R.drawable.sign23)));
        db.save(d23);
        Datamode d24= new Datamode("Pedestrian Crossing", imageConverter(getResources().getDrawable(R.drawable.sign24)));
        db.save(d24);
        Datamode d25= new Datamode("Road Dips", imageConverter(getResources().getDrawable(R.drawable.sign25)));
        db.save(d25);
        Datamode d26= new Datamode("Road Leads on the Quay or River Bank", imageConverter(getResources().getDrawable(R.drawable.sign26)));
        db.save(d26);
        Datamode d27= new Datamode("Slippery Roads", imageConverter(getResources().getDrawable(R.drawable.sign27)));
        db.save(d27);
        Datamode d28= new Datamode("Steep Ascents", imageConverter(getResources().getDrawable(R.drawable.sign28)));
        db.save(d28);
        Datamode d29= new Datamode("Strong Cross Wind ", imageConverter(getResources().getDrawable(R.drawable.sign29)));
        db.save(d29);
        Datamode d30= new Datamode("Swing Bridge", imageConverter(getResources().getDrawable(R.drawable.sign30)));
        db.save(d30);
        Datamode d31= new Datamode("Two Way Traffic", imageConverter(getResources().getDrawable(R.drawable.sign31)));
        db.save(d31);
        Datamode d32= new Datamode("Un-even Road", imageConverter(getResources().getDrawable(R.drawable.sign32)));
        db.save(d32);
        Datamode d33= new Datamode("Yield to the Traffic Approaching from the Right on the Cross Road", imageConverter(getResources().getDrawable(R.drawable.sign33)));
        db.save(d33);
        Datamode d34= new Datamode("Yield to the Traffic Approaching from the Right on any Leg of the Intersection", imageConverter(getResources().getDrawable(R.drawable.sign34)));
        db.save(d34);
        Datamode d35= new Datamode("Audible Warning Devices Prohibited", imageConverter(getResources().getDrawable(R.drawable.sign35)));
        db.save(d35);
        Datamode d36= new Datamode("Compulsory Roundabout", imageConverter(getResources().getDrawable(R.drawable.sign36)));
        db.save(d36);
        Datamode d37= new Datamode("Dual Carriageway Ahead", imageConverter(getResources().getDrawable(R.drawable.sign37)));
        db.save(d37);
        Datamode d38= new Datamode("Dual Carriageway End", imageConverter(getResources().getDrawable(R.drawable.sign38)));
        db.save(d38);
        Datamode d39= new Datamode("End of 30 Km/h Zone", imageConverter(getResources().getDrawable(R.drawable.sign39)));
        db.save(d39);
        Datamode d40= new Datamode("End of all Prohibitions Imposed", imageConverter(getResources().getDrawable(R.drawable.sign40)));
        db.save(d40);
        Datamode d41= new Datamode("End of Prohibitions of Overtaking", imageConverter(getResources().getDrawable(R.drawable.sign41)));
        db.save(d41);
        Datamode d42= new Datamode("End of Speed Limit Imposed", imageConverter(getResources().getDrawable(R.drawable.sign42)));
        db.save(d42);
        Datamode d43= new Datamode("Entry to 30 Km/h Zone", imageConverter(getResources().getDrawable(R.drawable.sign43)));
        db.save(d43);
        Datamode d44= new Datamode("Give Way or Stop Completely", imageConverter(getResources().getDrawable(R.drawable.sign44)));
        db.save(d44);
        Datamode d45= new Datamode("Go Straight or Left", imageConverter(getResources().getDrawable(R.drawable.sign45)));
        db.save(d45);
        Datamode d46= new Datamode("Go Straight or Right", imageConverter(getResources().getDrawable(R.drawable.sign46)));
        db.save(d46);
        Datamode d47= new Datamode("Keep to Left", imageConverter(getResources().getDrawable(R.drawable.sign47)));
        db.save(d47);
        Datamode d48= new Datamode("Keep to Right", imageConverter(getResources().getDrawable(R.drawable.sign48)));
        db.save(d48);
        Datamode d49= new Datamode("Lane Control Sign", imageConverter(getResources().getDrawable(R.drawable.sign49)));
        db.save(d49);
        Datamode d50= new Datamode("Maximum Speed 65 Km/h", imageConverter(getResources().getDrawable(R.drawable.sign50)));
        db.save(d50);
        Datamode d51= new Datamode("National Speed Limit Applies", imageConverter(getResources().getDrawable(R.drawable.sign51)));
        db.save(d51);
        Datamode d52= new Datamode("No Entry", imageConverter(getResources().getDrawable(R.drawable.sign52)));
        db.save(d52);
        Datamode d53= new Datamode("No Entry of Agriculture Vehicle", imageConverter(getResources().getDrawable(R.drawable.sign53)));
        db.save(d53);
        Datamode d54= new Datamode("No Entry of Animal Drawn Vehicle", imageConverter(getResources().getDrawable(R.drawable.sign54)));
        db.save(d54);
        Datamode d55= new Datamode("No Entry of Goods Vehicles", imageConverter(getResources().getDrawable(R.drawable.sign55)));
        db.save(d55);
        Datamode d56= new Datamode("No Entry for Hand Carts", imageConverter(getResources().getDrawable(R.drawable.sign56)));
        db.save(d56);
        Datamode d57= new Datamode("No Entry for Vehicles Exceeding 6-ton one axle", imageConverter(getResources().getDrawable(R.drawable.sign57)));
        db.save(d57);
        Datamode d58= new Datamode("No Entry for Vehicles Exceeding 7-ton Laden Weight", imageConverter(getResources().getDrawable(R.drawable.sign58)));
        db.save(d58);
        Datamode d59= new Datamode("No Entry for Vehicles Exceeding 10 Meter in Length", imageConverter(getResources().getDrawable(R.drawable.sign59)));
        db.save(d59);
        Datamode d60= new Datamode("No Entry for Vehicles Exceeding Height more than 16′-6″", imageConverter(getResources().getDrawable(R.drawable.sign60)));
        db.save(d60);
        Datamode d61= new Datamode("No Entry for Vehicles Exceeding Width more than 8′-6″", imageConverter(getResources().getDrawable(R.drawable.sign61)));
        db.save(d61);
        Datamode d62= new Datamode("No Stopping-Clearway", imageConverter(getResources().getDrawable(R.drawable.sign62)));
        db.save(d62);
        Datamode d63= new Datamode("Overtaking by Goods Vehicles Prohibited", imageConverter(getResources().getDrawable(R.drawable.sign63)));
        db.save(d63);
        Datamode d64= new Datamode("Overtaking Prohibited", imageConverter(getResources().getDrawable(R.drawable.sign64)));
        db.save(d64);
        Datamode d65= new Datamode("Passing Police Custom Post without Stopping", imageConverter(getResources().getDrawable(R.drawable.sign65)));
        db.save(d65);
        Datamode d66= new Datamode("Road Closed", imageConverter(getResources().getDrawable(R.drawable.sign66)));
        db.save(d66);
        Datamode d67= new Datamode("Stop", imageConverter(getResources().getDrawable(R.drawable.sign67)));
        db.save(d67);
        Datamode d68= new Datamode("Stop for Police Post", imageConverter(getResources().getDrawable(R.drawable.sign68)));
        db.save(d68);
        Datamode d69= new Datamode("Hospital", imageConverter(getResources().getDrawable(R.drawable.sign69)));
        db.save(d69);
        Datamode d70= new Datamode("Parking Place Indicated", imageConverter(getResources().getDrawable(R.drawable.sign70)));
        db.save(d70);
        Datamode d71= new Datamode("Breakdown Service", imageConverter(getResources().getDrawable(R.drawable.sign71)));
        db.save(d71);
        Datamode d72= new Datamode("Bus Stop", imageConverter(getResources().getDrawable(R.drawable.sign72)));
        db.save(d72);
        Datamode d73= new Datamode("Facility Indicated", imageConverter(getResources().getDrawable(R.drawable.sign73)));
        db.save(d73);
        Datamode d74= new Datamode("First Aid Station", imageConverter(getResources().getDrawable(R.drawable.sign74)));
        db.save(d74);
        Datamode d75= new Datamode("Hospital Ahead with Accident & Emergency Facilities", imageConverter(getResources().getDrawable(R.drawable.sign75)));
        db.save(d75);
        Datamode d76= new Datamode("Parking Place Direction", imageConverter(getResources().getDrawable(R.drawable.sign76)));
        db.save(d76);
        Datamode d77= new Datamode("Parking Place for Towed Caravans", imageConverter(getResources().getDrawable(R.drawable.sign77)));
        db.save(d77);
        Datamode d78= new Datamode("Parking Place Indicated", imageConverter(getResources().getDrawable(R.drawable.sign78)));
        db.save(d78);
        Datamode d79= new Datamode("School Bus-Displayed in front or near Window of Bus or Coach", imageConverter(getResources().getDrawable(R.drawable.sign79)));
        db.save(d79);
        Datamode d80= new Datamode("Telephone", imageConverter(getResources().getDrawable(R.drawable.sign80)));
        db.save(d80);
        Datamode d81= new Datamode("Tourist Information Point ", imageConverter(getResources().getDrawable(R.drawable.sign81)));
        db.save(d81);
        Datamode d82= new Datamode("Parking", imageConverter(getResources().getDrawable(R.drawable.sign82)));
        db.save(d82);
        Datamode d83= new Datamode("Advance Warning of Restriction or Prohibited Ahead", imageConverter(getResources().getDrawable(R.drawable.sign83)));
        db.save(d83);

    }
}