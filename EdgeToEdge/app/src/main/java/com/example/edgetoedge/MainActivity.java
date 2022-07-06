package com.example.edgetoedge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean isEdgeToEdge = false;
    public void GoEdgeToEdge(View view)
    {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), isEdgeToEdge);
        isEdgeToEdge=!isEdgeToEdge;
    }

    boolean isHidden = false;
    boolean isEdgeToEdgeForHidden = false;
    public void HideSystemBars(View view) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), isEdgeToEdgeForHidden);
        isEdgeToEdgeForHidden = !isEdgeToEdgeForHidden;

        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (windowInsetsController == null) {
            return;
        }
        if (!isHidden) {
            windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
        } else {
            windowInsetsController.show(WindowInsetsCompat.Type.systemBars());
        }
        isHidden=!isHidden;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}