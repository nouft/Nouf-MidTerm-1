package com.example.nouf_midterm_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;



public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        GridView gridview = (GridView) findViewById(R.id.simpleGridView);
        gridview.setAdapter(new ImageAdapter(this, gridview));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {
                Toast.makeText(MainActivity.this, "You clicked on " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    class ImageAdapter{
        private Context mContext;
        private GridView grid;

        public ImageAdapter(Context c, GridView gridview) {
            mContext = c;
            this.grid = gridview;
        }

        // image reference
        private Integer[] mThumbIds = {
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
        };

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(
                        grid.getWidth()/2,  grid.getHeight()/11));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }

}

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:orientation="vertical" >
<!-- numColumns example code -->
<GridView
        android:id="@+id/simpleGridView"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:numColumns="4"/>

<ImageView
        android:layout_width="match_parent"
                android:layout_height="match_parent"
</LinearLayout>