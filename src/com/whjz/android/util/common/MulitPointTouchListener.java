package com.whjz.android.util.common;


import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class MulitPointTouchListener implements OnTouchListener {
	public static final String TAG = "Touch";
	// These matrices will be used to move and zoom image
	Matrix matrix = new Matrix();
	Matrix savedMatrix = new Matrix();

	// We can be in one of these 3 states
	static final int NONE = 0;
	static final int DRAG = 1;
	static final int ZOOM = 2;
	int mode = NONE;
	int click=0;

	// Remember some things for zooming
	PointF start = new PointF();
	PointF mid = new PointF();
	float oldDist = 1f;
	public PopupWindow mPop;
	
	public MulitPointTouchListener(PopupWindow m_Pop) {
		// TODO Auto-generated constructor stub
		mPop=m_Pop;
	}
	
	public boolean onTouch(View v, MotionEvent event) {
		ImageView view = (ImageView) v;

		// Handle touch events here...
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:

			matrix.set(view.getImageMatrix());
			savedMatrix.set(matrix);
			start.set(event.getX(), event.getY());
			// Log.d(TAG, "mode=DRAG");
			mode = DRAG;
			click=1;
			// Log.d(TAG, "mode=NONE");
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			click=0;
			oldDist = spacing(event);
			// Log.d(TAG, "oldDist=" + oldDist);
			if (oldDist > 10f) {
				savedMatrix.set(matrix);
				midPoint(mid, event);
				mode = ZOOM;
				// Log.d(TAG, "mode=ZOOM");
			}
			break;
		case MotionEvent.ACTION_UP:
			if(click==1){
//				System.out.println("单点弹起");
				mPop.dismiss();
				return true;
			}
			break;
		case MotionEvent.ACTION_POINTER_UP:
			mode = NONE;
			// Log.e("view.getWidth", view.getWidth() + "");
			// Log.e("view.getHeight", view.getHeight() + "");

			break;
		case MotionEvent.ACTION_MOVE:
			if (mode == DRAG) {
				// ...
				matrix.set(savedMatrix);
				if(Math.abs(event.getX() - start.x)>10||Math.abs(event.getY()- start.y)>10){
					click=0;
				}
				matrix.postTranslate(event.getX() - start.x, event.getY()
						- start.y);
			} else if (mode == ZOOM) {
				float newDist = spacing(event);
				// Log.d(TAG, "newDist=" + newDist);
				if (newDist > 10f) {
					matrix.set(savedMatrix);
					float scale = newDist / oldDist;
					matrix.postScale(scale, scale, mid.x, mid.y);
				}
			}
			break;
		}

		view.setImageMatrix(matrix);
		return true; // indicate event was handled
	}


	private float spacing(MotionEvent event) {
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		return FloatMath.sqrt(x * x + y * y);
	}

	private void midPoint(PointF point, MotionEvent event) {
		float x = event.getX(0) + event.getX(1);
		float y = event.getY(0) + event.getY(1);
		point.set(x / 2, y / 2);
	}
	
	
//	private void center(boolean horizontal, boolean vertical,int map_width,int map_height) 
//    { 
//        Matrix m = new Matrix(); 
//        m.set(matrix); 
//        RectF rect = new RectF(0, 0, map_width, map_height); 
//        m.mapRect(rect); 
//        float height = rect.height(); 
//        float width = rect.width(); 
//        float deltaX = 0, deltaY = 0; 
//        if (vertical) 
//        { 
////            int screenHeight = dm.heightPixels;  //手机屏幕分辨率的高度  
//            int screenHeight = 400; 
//            if (height < screenHeight) 
//            { 
//                deltaY = (screenHeight - height)/2 - rect.top; 
//            }else if (rect.top > 0) 
//            { 
//                deltaY = -rect.top; 
//            }else if (rect.bottom < screenHeight) 
//            { 
//                deltaY = view.getHeight() - rect.bottom; 
//            } 
//        } 
//         
//        if (horizontal) 
//        { 
//            //int screenWidth = dm.widthPixels;  //手机屏幕分辨率的宽度  
//            int screenWidth = 400; 
//            if (width < screenWidth) 
//            { 
//                deltaX = (screenWidth - width)/2 - rect.left; 
//            }else if (rect.left > 0) 
//            { 
//                deltaX = -rect.left;     
//            }else if (rect.right < screenWidth) 
//            { 
//                deltaX = screenWidth - rect.right; 
//            } 
//        } 
//        matrix.postTranslate(deltaX, deltaY); 
//    }
}