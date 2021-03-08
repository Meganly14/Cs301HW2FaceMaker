/*
Author: @Megan Ly
 */
//@MeganLy
package com.example.hw2facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import android.graphics.Paint;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class Face extends SurfaceView {

    //call the face
    private Face thisFace;

    public Color skinColor;
    public Color eyeColor;
    public Color hairColor;
    public int hairStyle;

    //Paint for the eyes, hair, and face
    Paint facePaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint mouthPaint = new Paint();

    //Location
    private final float faceX = 800.0f;
    private final float faceY = 650.0f;
    private final float eyePosRightX = 550.0f;
    private final float eyePosLeftX = 1050.0f;
    private final float eyePosY = 450.0f;
    private final float eyeRadius = 50.0f;

    public Face(Context context) {
        super(context);

        //set background to white, og was black
        setBackgroundColor(Color.WHITE);

        thisFace = new Face(context);

        //fill the shapes
        facePaint.setStyle(Paint.Style.FILL);
        hairPaint.setStyle(Paint.Style.FILL);
        eyePaint.setStyle(Paint.Style.FILL);

        //black mouth
        mouthPaint.setColor(Color.BLACK);



    }



    //class to randomize
    //@RequiresApi(api = Build.VERSION_CODES.O)
    public void randomize (){
        int red;
        int blue;
        int green;

        //color randomization
        red = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);

        //skin color randomization
        skinColor = Color.valueOf(red, blue, green);

        //eye color randomization
        eyeColor = Color.valueOf(red, blue, green);

        //hair color randomization
        hairColor = Color.valueOf(red, green, blue);

        //
        hairStyle = (int)((Math.random() * 4));

    }

    public void drawHair(Canvas canvas, int hairStyle){
        switch(hairStyle){
            //short hair
            case 0:
                for(int i = 0; i < 100; i++){
                    canvas.drawLine((400 + i), 700, (400 + i), 1000, hairPaint);
                }
                break;

            //long
            case 1:
                for(int i = 0; i < 100; i++){
                    canvas.drawLine((400 + i), 700, (400 + i), 250, hairPaint);
                }
                break;

            //medium
            case 2:
                for(int i = 0; i < 100; i++){
                canvas.drawLine((400 + i), 700, (400 + i), 600, hairPaint);
                }
                break;

        }

    }

    //draw the face and other components
    @Override
    public void onDraw(Canvas canvas){
        colors();

        //draw the face(circle)
        canvas.drawCircle(faceX, faceY, 450.0f, facePaint);

        //draw the eyes
        canvas.drawCircle(eyePosRightX, eyePosY, eyeRadius, eyePaint); //Right eye
        canvas.drawCircle(eyePosLeftX, eyePosY, eyeRadius, eyePaint); // Left eye

        //draw the mouth
        RectF mouth = new RectF(eyePosLeftX, faceY, eyePosRightX, 1000.0f);
        canvas.drawArc(mouth, 0, 180, false, mouthPaint);



    }

    //set the colors for skin, eyes, and hair
    public void colors(){
        facePaint.setARGB( 255, ((int) thisFace.skinColor.red()), (int) thisFace.skinColor.blue(), (int) thisFace.skinColor.green());
        facePaint.setARGB(255, ((int) thisFace.eyeColor.red()), (int) thisFace.eyeColor.blue(), (int) thisFace.eyeColor.green());
        facePaint.setARGB(255, ((int) thisFace.hairColor.red()), (int) thisFace.hairColor.blue(), (int) thisFace.hairColor.green());
    }

    public Face getThisFace(){
        return thisFace;
    }
}
