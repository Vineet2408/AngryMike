package com.example.angrymike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.core.content.ContextCompat;

class Game extends SurfaceView implements SurfaceHolder.Callback
{
    private  Player player;
    GameLoop gameLoop;
    public Game(Context context) {
        super(context);
        SurfaceHolder surfaceHolder=getHolder();
        surfaceHolder.addCallback(this);
         player=new Player(getContext(),500,500,50);

        gameLoop=new GameLoop(this,surfaceHolder);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction())
        {
           case MotionEvent.ACTION_DOWN:
                player.setPosition(event.getX(),event.getY());
                return true;
           case MotionEvent.ACTION_MOVE:
                    player.setPosition(event.getX(),event.getY());
                    return true;
        }
        return super.onTouchEvent(event);
    }



    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        drawUPS(canvas);
        drawFPS(canvas);
        player.draw(canvas);
    }

   public void  drawUPS(Canvas canvas)
    {
        String avgUPS=Double.toString(gameLoop.getAverageUPS());
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);


        canvas.drawText("ups : "+avgUPS,100,20,paint);

    }
    public void  drawFPS(Canvas canvas)
    {
        String avgFPS=Double.toString(gameLoop.getAverageFPS());
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);

        canvas.drawText("Fps : "+avgFPS,100,100,paint);

    }
    public void update()
    {
        player.update();

    }
}
