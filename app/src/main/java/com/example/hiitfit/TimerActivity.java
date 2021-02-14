package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TimerActivity extends AppCompatActivity {
private static long START_TIME_IN_MILLI = 600000;
private static long ACTUAL_STARTED_TIMER;
TextView name,execution;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    String getName,getExecution,getCategory;
private TextView mTextViewCountDown;
private Button mButtonStartPause;
private Button mButtonReset;
     MediaPlayer md;
 Button mButton20, mButton30 , mButton45 , mButton60 , mButton90 , mButton120 , mButton240, mButton300 , mButtonminus, mButtonplus;

private CountDownTimer mCountDownTimer;

private boolean mTimerRunning;
CircularView cd;
private long mTimeLeftInMillis = START_TIME_IN_MILLI;

    String userID;
    FirebaseAuth mAuth;
    private FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
 md = MediaPlayer.create(TimerActivity.this,R.raw.timer);
        cd  = (CircularView) findViewById(R.id.circular_view);
name = (TextView)findViewById(R.id.name_Timer);
execution = (TextView)findViewById(R.id.execution_Timer);

getName = getIntent().getExtras().getString("Name");
getExecution = getIntent().getExtras().getString("Execution");
getCategory = getIntent().getExtras().getString("category");
        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        fstore = FirebaseFirestore.getInstance();
        calendar = Calendar.getInstance();

        ////////////////////////////

name.setText(getName);
execution.setText(getExecution);


        mTextViewCountDown = findViewById(R.id.TextView_Countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButton20 = findViewById(R.id.button_20);
        mButton30 = findViewById(R.id.button_30);
        mButton45 = findViewById(R.id.button_45);
        mButton60 = findViewById(R.id.button_60);
        mButton90 = findViewById(R.id.button_1_30);
        mButton120 = findViewById(R.id.button_2);
        mButton240 = findViewById(R.id.button_4);
        mButton300 = findViewById(R.id.button_5);
        mButtonminus = findViewById(R.id.buttonminus5);
        mButtonplus = findViewById(R.id.button5);

        mButtonReset = findViewById(R.id.Button_reset);
        mTimerRunning = false;

        mButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 20000;
                ACTUAL_STARTED_TIMER = 20000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));

            }
        });

        mButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 30000;
                ACTUAL_STARTED_TIMER = 30000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));

            }
        });

        mButton45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 45000;
                ACTUAL_STARTED_TIMER = 45000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });


        mButton60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 60000;
                ACTUAL_STARTED_TIMER = 60000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });


        mButton90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 90000;
                ACTUAL_STARTED_TIMER = 90000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });

        mButton120.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 120000;
                ACTUAL_STARTED_TIMER = 120000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });


        mButton240.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 240000;
                ACTUAL_STARTED_TIMER = 240000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });


        mButton300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = 300000;
                ACTUAL_STARTED_TIMER = 300000;
                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });
        mButtonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(START_TIME_IN_MILLI>5000) {
    START_TIME_IN_MILLI = START_TIME_IN_MILLI - 5000;
    ACTUAL_STARTED_TIMER = ACTUAL_STARTED_TIMER-5000;
    mTimeLeftInMillis = START_TIME_IN_MILLI;
    updateCountDownTextView();
}

if(START_TIME_IN_MILLI == 5000) {
    mButtonminus.setClickable(false);
    mButtonminus.setBackgroundColor(getResources().getColor(R.color.grey));
}
            }
        });
        mButtonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME_IN_MILLI = START_TIME_IN_MILLI + 5000;
                ACTUAL_STARTED_TIMER = ACTUAL_STARTED_TIMER +5000;

                mTimeLeftInMillis = START_TIME_IN_MILLI;
                updateCountDownTextView();
                mButtonminus.setClickable(true);
                mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });

       mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(mTimerRunning){
                    pauseTimer();
                }
                else{
                    cd.resumeTimer();
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownTextView();
    }



    private void startTimer() {
mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
    @Override
    public void onTick(long millisUntilFinished) {
        mTimeLeftInMillis = millisUntilFinished;
        updateCountDownTextView();

    }

    @Override
    public void onFinish() {
            mTimerRunning = false;
            mButtonStartPause.setText("Start");
            mButtonStartPause.setVisibility(View.VISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);
cd.stopTimer();
        START_TIME_IN_MILLI =600000;
        mTimeLeftInMillis = START_TIME_IN_MILLI;
        updateCountDownTextView();
        mButton20.setClickable(true);
        mButton20.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton30.setClickable(true);
        mButton30.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton45.setClickable(true);
        mButton45.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton60.setClickable(true);
        mButton60.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton90.setClickable(true);
        mButton90.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton120.setClickable(true);
        mButton120.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton240.setClickable(true);
        mButton240.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton300.setClickable(true);
        mButton300.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButtonplus.setClickable(true);
        mButtonplus.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButtonminus.setClickable(true);
        mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));
        Toasty.success(TimerActivity.this,"Time's Up", Toasty.LENGTH_SHORT).show();
       // Toast.makeText(TimerActivity.this, "Time's Up!!!" , Toast.LENGTH_SHORT).show();
        md.start();

        DocumentReference document = fstore.collection("users").document(userID);
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());




//updateFinishTimer();
                    int minutes = (int) (ACTUAL_STARTED_TIMER/1000) / 60;
                    int seconds = (int) (ACTUAL_STARTED_TIMER/1000) % 60;
                    String timeInMinutes = String.format(Locale.getDefault(),"%02d Min : %02d Sec",minutes,seconds);
                    String  userName =  documentSnapshot.getString("fName");
                    String  userEmail = documentSnapshot.getString("email");

                    Map<String,String> progress = new HashMap<>();
                    progress.put("Name", userName);
                    progress.put("Email", userEmail);
                    progress.put("ExerciseName", getName);
                    progress.put("Duration", timeInMinutes);
                    progress.put("DateAndTime",currentDateTimeString);
                    progress.put("Category",getCategory);

                    fstore.collection("Progress").add(progress).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
Toast.makeText(TimerActivity.this,"Progress Successfully Added",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TimerActivity.this,"Something Went Wrong"+ e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });


                }
                else {
                    Toast.makeText(TimerActivity.this, "row not found", Toast.LENGTH_LONG).show();
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(TimerActivity.this,"Failed to fetch data", Toast.LENGTH_LONG).show();
                    }
                });
    }
}.start();


        CircularView.OptionsBuilder builderWithoutText =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(false)
                        .setCounterInSeconds(CircularView.OptionsBuilder.INFINITE);


        cd.setOptions(builderWithoutText);

        cd.startTimer();
mTimerRunning = true;
mButtonStartPause.setText("Pause");
mButtonReset.setVisibility(View.INVISIBLE);
      //  mButton20.setVisibility(View.INVISIBLE);
       mButton20.setClickable(false);
        mButton20.setBackgroundColor(getResources().getColor(R.color.grey));
        mButton30.setClickable(false);
        mButton30.setBackgroundColor(getResources().getColor(R.color.grey));
        mButton45.setClickable(false);
        mButton45.setBackgroundColor(getResources().getColor(R.color.grey));
        mButton60.setClickable(false);
        mButton60.setBackgroundColor(getResources().getColor(R.color.grey));
        mButton90.setClickable(false);
        mButton90.setBackgroundColor(getResources().getColor(R.color.grey));
        mButton120.setClickable(false);
        mButton120.setBackgroundColor(getResources().getColor(R.color.grey));
        mButton240.setClickable(false);
        mButton240.setBackgroundColor(getResources().getColor(R.color.grey));
        mButton300.setClickable(false);
        mButton300.setBackgroundColor(getResources().getColor(R.color.grey));
        mButtonminus.setClickable(false);
        mButtonminus.setBackgroundColor(getResources().getColor(R.color.grey));
        mButtonplus.setClickable(false);
        mButtonplus.setBackgroundColor(getResources().getColor(R.color.grey));





    }




    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
        cd.pauseTimer();
    }

    private void resetTimer() {
        START_TIME_IN_MILLI = 600000;
        mTimeLeftInMillis = START_TIME_IN_MILLI;
        cd.stopTimer();
        updateCountDownTextView();
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setVisibility(View.VISIBLE);



        mButton20.setClickable(true);
        mButton20.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton30.setClickable(true);
        mButton30.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton45.setClickable(true);
        mButton45.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton60.setClickable(true);
        mButton60.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton90.setClickable(true);
        mButton90.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton120.setClickable(true);
        mButton120.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton240.setClickable(true);
        mButton240.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButton300.setClickable(true);
        mButton300.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButtonplus.setClickable(true);
        mButtonplus.setBackgroundColor(getResources().getColor(R.color.purple_500));
        mButtonminus.setClickable(true);
        mButtonminus.setBackgroundColor(getResources().getColor(R.color.purple_500));


    }


    private void updateCountDownTextView() {
        int minutes = (int) (mTimeLeftInMillis/1000) / 60;
        int seconds = (int) (mTimeLeftInMillis/1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        mTextViewCountDown.setText(timeLeftFormatted);

    }


}