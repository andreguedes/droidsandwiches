package br.com.andresguedes.sandwiches.widget;

import android.content.Context;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by aguedes on 02/08/17.
 */

public class NumberPickerWidget extends LinearLayout {

    private final long REPEAT_DELAY = 50;

    private final int ELEMENT_HEIGHT = 50;
    private final int ELEMENT_WIDTH = ELEMENT_HEIGHT;

    private final int MINIMUM = 1;
    private final int MAXIMUM = 999;

    private final int TEXT_SIZE = 12;
    private LayoutParams params = new LayoutParams(80, LayoutParams.WRAP_CONTENT);


    public Integer value;

    Button decrement;
    Button increment;
    public EditText valueText;

    private Handler repeatUpdateHandler = new Handler();

    private boolean autoIncrement = false;
    private boolean autoDecrement = false;

    /**
     * This little guy handles the auto part of the auto incrementing feature.
     * In doing so it instantiates itself. There has to be a pattern name for
     * that...
     *
     * @author Jeffrey F. Cole
     */
    class RepetetiveUpdater implements Runnable {
        public void run() {
            if (autoIncrement) {
                increment();
                repeatUpdateHandler.postDelayed(new RepetetiveUpdater(), REPEAT_DELAY);
            } else if (autoDecrement) {
                decrement();
                repeatUpdateHandler.postDelayed(new RepetetiveUpdater(), REPEAT_DELAY);
            }
        }
    }

    public void onValueChange() {

    }

    public NumberPickerWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        this.setLayoutParams(params);
        // LayoutParams elementParams = new LinearLayout.LayoutParams(ELEMENT_HEIGHT, ELEMENT_WIDTH);

        // init the individual elements
        initDecrementButton(context);
        initValueEditText(context);
        initIncrementButton(context);

        // Can be configured to be vertical or horizontal
        // Thanks for the help, LinearLayout!
        if (getOrientation() == VERTICAL) {
            addView(increment, params);
            addView(valueText, params);
            addView(decrement, params);
        } else {
            addView(decrement, params);
            addView(valueText, params);
            addView(increment, params);
        }
    }

    public void setSize(Integer height, Integer width) {
        LayoutParams elementParams = new LayoutParams(height, width);
        if (getOrientation() == VERTICAL) {
            removeView(increment);
            addView(increment, params);
            removeView(valueText);
            addView(valueText, params);
            removeView(decrement);
            addView(decrement, params);
        } else {
            removeView(decrement);
            addView(decrement, params);
            removeView(valueText);
            addView(valueText, params);
            removeView(increment);
            addView(increment, params);
        }
    }

    private void initIncrementButton(Context context) {
        increment = new Button(context);
        increment.setTextSize(TEXT_SIZE);
        increment.setText("+");
        increment.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);


        // Increment once for a click
        increment.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                increment();
            }
        });

        // Auto increment for a long click
        increment.setOnLongClickListener(
                new OnLongClickListener() {
                    public boolean onLongClick(View arg0) {
                        autoIncrement = true;
                        repeatUpdateHandler.post(new RepetetiveUpdater());
                        return false;
                    }
                }
        );

        // When the button is released, if we're auto incrementing, stop
        increment.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && autoIncrement) {
                    autoIncrement = false;
                }
                return false;
            }
        });
    }

    private void initValueEditText(Context context) {

        value = new Integer(0);

        valueText = new EditText(context);
        valueText.setTextSize(TEXT_SIZE);
        valueText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});

        // Since we're a number that gets affected by the button, we need to be
        // ready to change the numeric value with a simple ++/--, so whenever
        // the value is changed with a keyboard, convert that text value to a
        // number. We can set the text area to only allow numeric input, but
        // even so, a carriage return can get hacked through. To prevent this
        // little quirk from causing a crash, store the value of the internal
        // number before attempting to parse the changed value in the text area
        // so we can revert to that in case the text change causes an invalid
        // number
        valueText.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int arg1, KeyEvent event) {
                int backupValue = value;
                try {
                    value = Integer.parseInt(((EditText) v).getText().toString());
                } catch (NumberFormatException nfe) {
                    value = backupValue;
                }
                return false;
            }
        });

        // Highlight the number when we get focus
        valueText.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ((EditText) v).selectAll();
                }
            }
        });
        valueText.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        valueText.setText(value.toString());
        valueText.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    private void initDecrementButton(Context context) {
        decrement = new Button(context);
        decrement.setTextSize(TEXT_SIZE);
        decrement.setText("-");
        decrement.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        // Decrement once for a click
        decrement.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                decrement();
            }
        });


        // Auto Decrement for a long click
        decrement.setOnLongClickListener(
                new OnLongClickListener() {
                    public boolean onLongClick(View arg0) {
                        autoDecrement = true;
                        repeatUpdateHandler.post(new RepetetiveUpdater());
                        return false;
                    }
                }
        );

        // When the button is released, if we're auto decrementing, stop
        decrement.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && autoDecrement) {
                    autoDecrement = false;
                }
                return false;
            }
        });
    }

    public void increment() {
        if (value < MAXIMUM) {
            value = value + 1;
            valueText.setText(value.toString());
        }
    }

    public void decrement() {
        if (value > MINIMUM) {
            value = value - 1;
            valueText.setText(value.toString());
        }
    }

    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        if (value > MAXIMUM) value = MAXIMUM;
        if (value >= 0) {
            this.value = value;
            valueText.setText(this.value.toString());
        }
    }

    public Button getDecrement() {
        return decrement;
    }

    public void setDecrement(Button decrement) {
        this.decrement = decrement;
    }

    public Button getIncrement() {
        return increment;
    }

    public void setIncrement(Button increment) {
        this.increment = increment;
    }

    public EditText getValueText() {
        return valueText;
    }

    public NumberPickerWidget setValueText(EditText valueText) {
        this.valueText = valueText;
        return this;
    }
}