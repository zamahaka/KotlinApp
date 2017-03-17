package com.nulp.yurastetsyc.atomaskotlin.activity.view

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.nulp.yurastetsyc.atomaskotlin.activity.thread.DrawThread

/**
 * Created by Yura Stetsyc on 3/17/17.
 */
class GameSurfaceView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    init {
        holder.addCallback(this)
    }

    private val mDrawThread by lazy { DrawThread(holder, resources) }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        mDrawThread.setRunning(true)
        mDrawThread.start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        var retry = true
        // завершаем работу потока
        mDrawThread.setRunning(false)
        while (retry) {
            try {
                mDrawThread.join()
                retry = false
            } catch (e: InterruptedException) {
                // если не получилось, то будем пытаться еще и еще
            }

        }
    }
}