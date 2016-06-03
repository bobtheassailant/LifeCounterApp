package com.example.louie.lifecounter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LifeCounterActivity extends AppCompatActivity {
    // declare our view variables
    private TextView mLeftView;
    private Button mLPlusOne;
    private Button mLMinusOne;
    private FrameLayout mLeftLayout;
    private FrameLayout mRightLayout;
    private TextView mRightView;
    private Button mRPlusOne;
    private Button mRMinusOne;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_counter);

        // assign the views from the layout file to the variables above.
        mLeftView = (TextView) findViewById(R.id.LeftView);
        mLPlusOne = (Button) findViewById(R.id.LPlusOne);
        mLMinusOne = (Button) findViewById(R.id.LMinusOne);
        mLeftLayout = (FrameLayout) findViewById(R.id.leftFragment);
        mRightView = (TextView) findViewById(R.id.RightView);
        mRPlusOne = (Button) findViewById(R.id.RPlusOne);
        mRMinusOne = (Button) findViewById(R.id.RMinusOne);
        mRightLayout = (FrameLayout) findViewById(R.id.rightFragment);


        mLeftLayout.setBackgroundColor(Color.WHITE);
        mRightLayout.setBackgroundColor(Color.WHITE);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            View.OnClickListener LPlusOneListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //whenever plusOne is pressed, add one to the value of lifeView and return it
                    String lifeNum = mLeftView.getText().toString();
                    int t = Integer.parseInt(lifeNum) + 1;
                    mLeftView.setText(Integer.toString(t));


                    if (t < 6) {
                        mLeftLayout.setBackgroundColor(Color.RED);

                    } else {
                        mLeftLayout.setBackgroundColor(Color.WHITE);
                    }

                    if (t > 20) {
                        mLeftLayout.setBackgroundColor(Color.GREEN);
                    }

                }

            };

            final View.OnLongClickListener LPlusOneLongListener = new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View mLPlusOne) {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(LifeCounterActivity.this);
                    final EditText editText = new EditText(LifeCounterActivity.this);
                    alertDialog.setTitle("Add Life!");
                    alertDialog.setView(editText);
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    editText.setRawInputType(Configuration.KEYBOARD_12KEY);
                    editText.setFilters(new InputFilter[]{
                            // Maximum 5 characters.
                         new InputFilter.LengthFilter(5),
                    });


                    alertDialog.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface alertDialog, int whichButton) {
                            //get the values of the users input into the alert dialog and mLeftView and turn them to strings
                            String addNum = editText.getText().toString();
                            String lifeNum = mLeftView.getText().toString();
                            //parse the ints from the newly formed strings
                            int a = Integer.parseInt(addNum);
                            int t = Integer.parseInt(lifeNum);
                            //add the values together
                            int f = t + a;
                            //set the textview to the updated life value
                            mLeftView.setText(Integer.toString(f));


                        }
                    });

                    alertDialog.show();

                    return true;
                }
            };
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            View.OnClickListener LMinusOneListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //whenever minusOne is pressed, sub one from the value of lifeView and return it
                    String lifeNum = mLeftView.getText().toString();
                    int t = Integer.parseInt(lifeNum) - 1;
                    mLeftView.setText(Integer.toString(t));


                    if (t < 6) {
                        mLeftLayout.setBackgroundColor(Color.RED);
                    } else {
                        mLeftLayout.setBackgroundColor(Color.WHITE);
                    }
                    if (t > 20) {
                        mLeftLayout.setBackgroundColor(Color.GREEN);
                    }
                }
            };

        final View.OnLongClickListener LMinusOneLongListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View mLMinusOne) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(LifeCounterActivity.this);
                final EditText editText = new EditText(LifeCounterActivity.this);
                alertDialog.setTitle("Subtract Life!");
                alertDialog.setView(editText);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setRawInputType(Configuration.KEYBOARD_12KEY);
                editText.setFilters(new InputFilter[]{
                        // Maximum 5 characters.
                        new InputFilter.LengthFilter(5),
                });


                alertDialog.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alertDialog, int whichButton) {
                        //get the values of the users input into the alert dialog and mLeftView and turn them to strings
                        String addNum = editText.getText().toString();
                        String lifeNum = mLeftView.getText().toString();
                        //parse the ints from the newly formed strings
                        int a = Integer.parseInt(addNum);
                        int t = Integer.parseInt(lifeNum);
                        //subtract the user inputted amount from the current life total
                        int f = t - a;
                        //set the textview to the updated life value
                        mLeftView.setText(Integer.toString(f));


                    }
                });

                alertDialog.show();

                return true;
            }
        };
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            View.OnClickListener RPlusOneListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //whenever plusOne is pressed, add one to the value of lifeView and return it
                    String lifeNum = mRightView.getText().toString();
                    int t = Integer.parseInt(lifeNum) + 1;
                    mRightView.setText(Integer.toString(t));


                    if (t < 6) {
                        mRightLayout.setBackgroundColor(Color.RED);
                    } else {
                        mRightLayout.setBackgroundColor(Color.WHITE);
                    }
                    if (t > 20) {
                        mRightLayout.setBackgroundColor(Color.GREEN);
                    }
                }
            };

        final View.OnLongClickListener RPlusOneLongListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View mRPlusOne) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(LifeCounterActivity.this);
                final EditText editText = new EditText(LifeCounterActivity.this);
                alertDialog.setTitle("Add Life!");
                alertDialog.setView(editText);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setRawInputType(Configuration.KEYBOARD_12KEY);
                editText.setFilters(new InputFilter[]{
                        // Maximum 5 characters.
                        new InputFilter.LengthFilter(5),
                });


                alertDialog.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alertDialog, int whichButton) {
                        //get the values of the users input into the alert dialog and mLeftView and turn them to strings
                        String addNum = editText.getText().toString();
                        String lifeNum = mLeftView.getText().toString();
                        //parse the ints from the newly formed strings
                        int a = Integer.parseInt(addNum);
                        int t = Integer.parseInt(lifeNum);
                        //add the values together
                        int f = t + a;
                        //set the textview to the updated life value
                        mRightView.setText(Integer.toString(f));


                    }
                });

                alertDialog.show();

                return true;
            }
        };
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            View.OnClickListener RminusOneListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //whenever minusOne is pressed, sub one from the value of lifeView and return it
                    String lifeNum = mRightView.getText().toString();
                    int t = Integer.parseInt(lifeNum) - 1;
                    mRightView.setText(Integer.toString(t));


                    if (t < 6) {
                        mRightLayout.setBackgroundColor(Color.RED);
                    } else {
                        mRightLayout.setBackgroundColor(Color.WHITE);
                    }
                    if (t > 20) {
                        mRightLayout.setBackgroundColor(Color.GREEN);
                    }
                }
            };

        final View.OnLongClickListener RMinusOneLongListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View mRMinusOne) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(LifeCounterActivity.this);
                final EditText editText = new EditText(LifeCounterActivity.this);
                alertDialog.setTitle("Subtract Life!");
                alertDialog.setView(editText);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setRawInputType(Configuration.KEYBOARD_12KEY);
                editText.setFilters(new InputFilter[]{
                        // Maximum 5 characters.
                        new InputFilter.LengthFilter(5),
                });


                alertDialog.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alertDialog, int whichButton) {
                        //get the values of the users input into the alert dialog and mLeftView and turn them to strings
                        String addNum = editText.getText().toString();
                        String lifeNum = mRightView.getText().toString();
                        //parse the ints from the newly formed strings
                        int a = Integer.parseInt(addNum);
                        int t = Integer.parseInt(lifeNum);
                        //subtract the user inputted amount from the current life total
                        int f = t - a;
                        //set the textview to the updated life value
                        mRightView.setText(Integer.toString(f));


                    }
                });

                alertDialog.show();

                return true;
            }
        };

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        mLPlusOne.setOnClickListener(LPlusOneListener);
        mLMinusOne.setOnClickListener(LMinusOneListener);
        mRPlusOne.setOnClickListener(RPlusOneListener);
        mRMinusOne.setOnClickListener(RminusOneListener);
        mLPlusOne.setOnLongClickListener(LPlusOneLongListener);
        mLMinusOne.setOnLongClickListener(LMinusOneLongListener);
        mRPlusOne.setOnLongClickListener(RPlusOneLongListener);
        mRMinusOne.setOnLongClickListener(RMinusOneLongListener);


    }
}
