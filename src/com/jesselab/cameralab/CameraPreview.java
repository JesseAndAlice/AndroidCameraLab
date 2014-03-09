/**
 * 
 */
package com.jesselab.cameralab;

import java.util.List;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * @author JesseAndAlice
 *
 */
public class CameraPreview extends SurfaceView implements Callback {

	private SurfaceHolder mHolder;
	private Size mPreviewSize;
	private List<Size> mSupportedPreviewSizes;
	private Camera mCamera;
	private int mViewOrientation;
	
	public final static int VIEW_PORTRAIT = 0;
	public final static int VIEW_LANDSCAPE = 1;
	
	CameraPreview(Context context){
		super(context);
		// TODO:
		mHolder = this.getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		mViewOrientation = VIEW_PORTRAIT;
	}
	
	CameraPreview(Context context, int viewOrientation){
		super(context);
		// TODO:
		mHolder = this.getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		mViewOrientation = viewOrientation;
	}
	
	
	/* (non-Javadoc)
	 * @see android.view.SurfaceHolder.Callback#surfaceChanged(android.view.SurfaceHolder, int, int, int)
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.view.SurfaceHolder.Callback#surfaceCreated(android.view.SurfaceHolder)
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.view.SurfaceHolder.Callback#surfaceDestroyed(android.view.SurfaceHolder)
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}
	
	
	private Size getOptimalPreviewSize(List<Size> sizes, int w, int h){
		Size optimalSize = null;
		
		switch(mViewOrientation){
		case VIEW_PORTRAIT:
			optimalSize = getOptimalPreviewSizeWithPortraitOrientation(sizes, w, h);
			break;
			
		case VIEW_LANDSCAPE:
			optimalSize = getOptimalPreviewSizeWithLandscapeOrientation(sizes, w, h);
			break;
		}
		
		return optimalSize;
	}

	
	/*
	 * 
	 * */
	private Size getOptimalPreviewSizeWithPortraitOrientation(List<Size> sizes, int w, int h){
		Size optimalSize = null;
		
		
		return optimalSize;
	}
	
	
	/*
	 * 
	 * */
	private Size getOptimalPreviewSizeWithLandscapeOrientation(List<Size> sizes, int w, int h){
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if (sizes == null)
            return null;

        Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        // Try to find an size match aspect ratio and size
        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE)
                continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        // Cannot find the one match the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
	}
	
}
