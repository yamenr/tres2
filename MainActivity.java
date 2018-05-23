package com.spacex.jeries.tres2;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1, iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        iv1 = (ImageView)findViewById(R.id.imgBlue);
        iv2 = (ImageView)findViewById(R.id.imgRed);
        iv1.setOnTouchListener(new ChoiceTouchListener());
        iv1.setOnDragListener(new ChoiceDragListener());
        iv2.setOnTouchListener(new ChoiceTouchListener());
        iv2.setOnDragListener(new ChoiceDragListener());
    }

    private final class ChoiceTouchListener implements View.OnTouchListener
    {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if ((event.getAction() == MotionEvent.ACTION_DOWN) && (((ImageView)v).getDrawable() != null))
            {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,shadowBuilder,v,0);
                return true;
            }
            else
                return false;
        }
    }

    public class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction())
            {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;

                case DragEvent.ACTION_DROP:
                    ImageView view = (ImageView) event.getLocalState();
                    ((ImageView)v).setImageDrawable(getResources().getDrawable(R.drawable.blue));
                    ((ImageView)view).setImageDrawable(null);
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    break;
            }

            return true;
        }
    }

}
