
package com.implicit.example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.implicit.example.databinding.ActivityMainBinding;

import android.content.Intent;

import android.widget.Button;

import android.widget.EditText;

import android.view.View;

import android.net.Uri;


import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());
        
        //get ides
        EditText input = findViewById(R.id.edittext1);
        
        Button button = findViewById(R.id.button1);
        
        
        
        
        
        
        
        //Action button
        
        button.setOnClickListener(new View.OnClickListener(){
            
               
            @Override
            public void onClick(View v){
                
                    String in = input.getText().toString();
                    
                    
                    
                    if(!in.isEmpty()&&in.startsWith("http://")|| in.startsWith("https://")  ){
                        
                        openUrl(in);
                        
                    }
                    else{
                        
                      Toast obj =   Toast.makeText(MainActivity.this,"You are Entered empty or worng url please check and try again", Toast.LENGTH_LONG);
        
                        obj.show();
                    }
                    
            }
            
            
        });
        
        
    }
    
    // Open an link using implcit intent method
    
   private void openUrl(String url){
                     Toast toast = new Toast(this);
        
        Uri link = Uri.parse(url);
    Intent intent = new Intent(Intent.ACTION_VIEW, link);
          
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }
        else{
            
            
            
            Toast.makeText(this,"failed to start intent",Toast.LENGTH_SHORT);
        }
        
        
        
        
    }
    
    
    
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
