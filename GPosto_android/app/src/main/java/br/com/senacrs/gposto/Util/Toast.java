package br.com.senacrs.gposto.Util;

import android.content.Context;
import android.view.Gravity;

public class Toast {

    public static void longToast(Context context, String message){
        android.widget.Toast msg = android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_LONG);
        msg.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 350);
        msg.show();
    }

    public static void shortToast(Context context, String message){
        android.widget.Toast msg = android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT);
        msg.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 350);
        msg.show();
    }
}

