package com.example.slidecutlistview;

import android.R.integer;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SlideCutListView extends ListView {

	private float downX;
	private float downY;
	private float rawX;
	private float rawY;

	public SlideCutListView(Context context) {
		super(context);
	}

	public SlideCutListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SlideCutListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		View view = null;
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			downX = ev.getX();
			downY = ev.getY();
			int slidePosition = pointToPosition((int) downX, (int) downY);
			System.out.println(slidePosition);
			if (slidePosition == AdapterView.INVALID_POSITION)
				return super.onTouchEvent(ev);
			view = getChildAt(slidePosition - getFirstVisiblePosition());
			view.scrollBy(20, 0);
			// rawX = ev.getRawX();
			// rawY = ev.getRawY();
			System.out.println("downx--" + downX);
			System.out.println("downy--" + downY);

			// System.out.println("rawx--"+rawX);
			//
			// System.out.println("rawy--"+rawY);

			break;
		case MotionEvent.ACTION_MOVE:
			System.out.println("move");
			float dx = ev.getX() - downX;
			float dy = ev.getY() - downY;

			view.scrollBy((int) dx, 0);
			// System.out.println("dx--" + dx);
			// System.out.println("dy--" + dy);
			break;

		case MotionEvent.ACTION_UP:
			System.out.println("up");

			break;

		default:
			break;
		}
		return super.onTouchEvent(ev);
	}

}
