package com.example.powerbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class PowerBroadcastReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = View.inflate(context, R.layout.custom_toast, null);
        ShapeableImageView imageView = view.findViewById(R.id.image_toast);

        if (intentAction != null)
        {
            String message = "Unknown intent action";
            switch (intentAction) {
                case Intent.ACTION_POWER_DISCONNECTED:
                    message = "Power Disconnected";
                    imageView.setImageResource(R.drawable.ic_round_electric_bolt_24);
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    message = "Power Connected";
                    imageView.setImageResource(R.drawable.ic_round_electric_bolt_24);
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    message = "Custom Broadcast received";
                    break;
            }

            MaterialTextView textView = view.findViewById(R.id.view_toast_message);
            textView.setText(message);

            Toast toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(view);
            toast.show();
        }
    }
}