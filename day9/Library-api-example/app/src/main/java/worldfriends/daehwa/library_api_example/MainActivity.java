package worldfriends.daehwa.library_api_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_main);
        com.beardedhen.androidbootstrap.BootstrapButton dateBtn=(com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.date_picker);
        dateBtn.setOnClickListener(dateButton);
        com.beardedhen.androidbootstrap.BootstrapButton timeBtn=(com.beardedhen.androidbootstrap.BootstrapButton)findViewById(R.id.time_picker);
        timeBtn.setOnClickListener(timeButton);
        com.beardedhen.androidbootstrap.BootstrapProgressBar hello=(com.beardedhen.androidbootstrap.BootstrapProgressBar)findViewById(R.id.process);
        hello.setProgress(20);
    }
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "You picked the following date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        //dateTextView.setText(date);
    }
    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute,int second) {
        String time = "You picked the following time: "+hourOfDay+"h"+minute;
        //timeTextView.setText(time);
    }
    com.beardedhen.androidbootstrap.BootstrapButton.OnClickListener dateButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar now = Calendar.getInstance();
            DatePickerDialog dpd = DatePickerDialog.newInstance(
                    MainActivity.this,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );
            dpd.show(getFragmentManager(), "Datepickerdialog");
        }
    };

    com.beardedhen.androidbootstrap.BootstrapButton.OnClickListener timeButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar now = Calendar.getInstance();
            TimePickerDialog tpd = TimePickerDialog.newInstance(
                    MainActivity.this,
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    false
            );
            tpd.show(getFragmentManager(), "Timepickerdialog");
        }
    };
}
