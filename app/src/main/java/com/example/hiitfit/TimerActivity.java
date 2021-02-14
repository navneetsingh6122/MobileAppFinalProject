package com.example.hiitfit;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;
import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
private static long START_TIME_IN_MILLI = 600000;
TextView name,execution;
String getName,getExecution;
private TextView mTextViewCountDown;
private Button mButtonStartPause;
private Button mButtonReset;
     MediaPlayer md;
 Button mButton20, mButton30 , mButton45 , mButton60 , mButton90 , mButton120 , mButton240, mButton300 , mButtonminus, mButtonplus;

private CountDownTimer mCountDownTimer;

private boolean mTimerRunning;
CircularView cd;
private long mTimeLeftInMillis = START_TIME_IN_MILLI;

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