package com.example.angrymike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Player
{

    public Player(Context context, float posx, float posy, float radius) {
        this.posx = posx;
        this.posy = posy;
        this.radius = radius;
        paint=new Paint();
        paint.setColor(Color.RED);

    }

    float posx,posy,radius;
    Paint paint;
    public void draw(Canvas canvas)
    {
        canvas.drawCircle(posx,posy,radius,paint);
        canvas.drawRect(posx-radius,posy+radius,posx+radius,posy+3*radius,paint);
    }

    public void update()
    {

    }

    public void setPosition(float x, float y)
    {
        this.posx=x;
        this.posy=y;
    }
}
