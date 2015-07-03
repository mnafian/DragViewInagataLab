package com.inagata.appsm;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;

import at.markushi.ui.CircleButton;


public class MainActivity extends ActionBarActivity {
    private RelativeLayout addElementLayout;
    private Button addElementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addElementLayout = (RelativeLayout) findViewById(R.id.addElementArea);
        addElementButton = (Button) findViewById(R.id.addElementButton);

        addElementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewView();
            }
        });
    }

    private void addNewView(){
        final RelativeLayout newAddView;
        final CircleButton closeView;

        newAddView = (RelativeLayout) View.inflate(this, R.layout.dynamic_view, null);
        closeView = (CircleButton) newAddView.findViewById(R.id.bt_deleteText);


        final int[] _xDelta = new int[1];
        final int[] _yDelta = new int[1];

        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newAddView.setVisibility(View.GONE);
            }
        });

        addElementLayout.addView(newAddView);

        newAddView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                closeView.setVisibility(View.VISIBLE);

                final int X = (int) event.getRawX();
                final int Y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        _xDelta[0] = X - lParams.leftMargin;
                        _yDelta[0] = Y - lParams.topMargin;
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = X - _xDelta[0];
                        layoutParams.topMargin = Y - _yDelta[0];
                        layoutParams.rightMargin = -250;
                        layoutParams.bottomMargin = -250;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                return true;
            }
        });
    }
}
