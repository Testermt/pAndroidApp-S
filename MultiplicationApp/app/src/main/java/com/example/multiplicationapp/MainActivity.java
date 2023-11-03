
package com.example.multiplicationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import android.widget.ScrollView;

import android.view.View;

import android.widget.LinearLayout;

import android.widget.Toast;


import java.util.LinkedList;


import android.widget.Button;

import android.widget.EditText;

import android.graphics.Color;

import com.example.multiplicationapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    
    
    private int Index=1;
    private View child;
    private EditText input;
    
    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());
        
        //get ides
        ScrollView scroll = findViewById(R.id.scrollV);
        
        
        Button button = findViewById(R.id.Print);
        
        input= findViewById(R.id.input);
        
        //get Scroll View Child 
       child = scroll.getChildAt(0);
        
        
        //Print Button
        button.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View v){
                    
                    
                    
                   String text = input.getText().toString();
                    
                    
                    
                    if(!text.isEmpty()){
                        
                        Integer cint = new Integer(0);
                        
                        try{
                        cint = cint.decode(text);
                            
                            long cLInt = cint.longValue();
                            
                            addView(createNewTextView(),"😀:Table of " + text.valueOf(cLInt),Color.RED);
                            
                            for(long i=0;i<10;i++){
                            addView(createNewTextView(),text.valueOf(cLInt*(i+1)),Color.BLUE);
                     }
                        }
                        catch(Exception e){
                            
                            addView(createNewTextView(),"Error: 😬 Enter number only\n"+e.toString(),Color.GREEN);
                            
                        }
                        
                        
                    }
                    
                    else{
                        
                        addView(createNewTextView(),"please Enter AnyNumber",Color.GREEN);
                        
                    }
                }
                
                
                
        });
        
 }
    
    
    
    //Create List of TextView
    public TextView createNewTextView(){
        
            
        
       return new TextView(this);
    }
    
    
    
    
    
    //Add View in Linear Layout
    
    
    public void addView(TextView show,String text,int color){
        
         if(child instanceof LinearLayout){
            
            
            
            LinearLayout obj = (LinearLayout)child;
            
            
            show.setTextColor(color);
            
            show.setTextSize(12);
            
            show.setText(text);
            
            obj.addView(show,Index);
            
            
            
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)show .getLayoutParams();
            
            if(Index==1){
           params.setMargins(29,90,0,0);
            
            }
            else{
                
                   
            params.setMargins(90,23,0,0);
            
            
            
            }
            Index++;
            
            
        }
        
    }
    
    
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}

/*
<TextView
                 android:layout_height="wrap_content"
                 android:layout_width="wrap_content"
                 android:textSize="12sp"
                 android:layout_marginLeft="29dp"
                 android:textColor="#1565C0"
                 android:layout_marginTop="25dp"
                 android:id="@+id/textview4"
                 android:text="10"
                 android:textStyle="bold|italic" />


*/