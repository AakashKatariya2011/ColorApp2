package com.example.alex.colorapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.BitmapCompat;

/**
 * Created by Alex on 10/9/2018.
 */

public class Colorful {

    private Bitmap bitmap;
    private float redColorValue;
    private float greenColorValue;
    private float blueColorValue;

    public Colorful(Bitmap bitmap, float redValue, float greenValue, float blueValue){
        this.bitmap = bitmap;
        setRedColorValue(redValue);
        setGreenColorValue(greenValue);
        setBlueColorValue(blueValue);

    }

    public void setRedColorValue(float redValue){
        if(redValue >= 0 && redValue <= 1){
            redColorValue = redValue;
        }
    }

    public void setGreenColorValue(float greenValue){
        if(greenValue >= 0 && greenValue <= 1){
            greenColorValue = greenValue;
        }
    }

    public void setBlueColorValue(float blueValue){
        if(blueValue >= 0 && blueValue <= 1){
            blueColorValue = blueValue;
        }
    }

    public float getRedColorValue(){
        return redColorValue;
    }

    public float getGreenColorValue(){
        return greenColorValue;
    }

    public float getBlueColorValue(){
        return blueColorValue;
    }

    public Bitmap returnColorizedBitmap(){

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        Bitmap.Config bitmapConfig = bitmap.getConfig();

        Bitmap locatBitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, bitmapConfig);

        for(int row = 0; row < bitmapWidth; row++){
            for(int col = 0; col < bitmapHeight; col++){

                int pixelColor = bitmap.getPixel(row, col);

                pixelColor = Color.argb(Color.alpha(pixelColor), (int) redColorValue * Color.red(pixelColor),
                        (int) greenColorValue * Color.green(pixelColor), (int) blueColorValue * Color.blue(pixelColor));

                locatBitmap.setPixel(row, col, pixelColor);
            }
        }

        return locatBitmap;
    }

}
