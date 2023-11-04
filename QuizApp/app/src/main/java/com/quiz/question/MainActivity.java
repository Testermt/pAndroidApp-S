
package com.quiz.question;

//import android.R;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.quiz.question.databinding.ActivityMainBinding;


import android.widget.EditText;

import android.widget.TextView;

import android.widget.Button;

import com.quiz.question.R;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    
    String questions[] = {"java is Interperter language ?","Java is compile language ?","java is invented in 1990s ?","hygg"};
    
    boolean answer[] =  {false,true,true};
    
    int index=0;
    
    int score=0;
  
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());
        
        
        quiz();
        
    }
    
    
    public void quiz(){
        
       
        
    
        
        TextView show = findViewById(R.id.show);
      Button Yes = findViewById(R.id.Yes);
      Button No = findViewById(R.id.No);
        
    Button ResetQuiz = findViewById(R.id.ResetQuiz);
        
        
        
        int answerLength =answer.length-1;
        show.setText("Q:"+index+1+" "+questions[index]);
        
        
        ResetQuiz.setEnabled(false);
        
        
        
       ResetQuiz.setOnClickListener(new View.OnClickListener(){
            
                @Override
                public void onClick(View v){
                
                    Yes.setEnabled(true);
                            
                            No.setEnabled(true);
                    
                    index=0;
                    score=0;
                    resetQuiz();
        
        
        
        }
                });
        
        
        
        
        
        
        
        
        Yes.setOnClickListener(new View.OnClickListener(){
            
                
                 @Override
                 public void onClick(View v){
                    
                    
                    if(index <= answerLength) {
                    	
                    
                    if(answer[index]){
                        
                        score++;
                            
                            
                    }
                    
                        index++;
                        
                        if(index <= answerLength){
                            
                    show.setText("Q:"+index + 1+" "+questions[index]);
                        }
                        else{
                            
                            Yes.setEnabled(false);
                            
                            No.setEnabled(false);
                            ResetQuiz.setEnabled(true);
                            
                            if(score <= answerLength)
                            show.setText("Your correct answer is : "+score);
                            else
                            show.setText("Wow Congratulations 👏🎉 your all answer is correct");
                            
                            
                            
                        }
              
                }
                    
                }
                
        });
        
        
        
       @Override
       No.setOnClickListener(new View.OnClickListener(){
            
                
                
                public void onClick(View v){
                    
                    
                    if(index <= answerLength) {
                    	
                    
                    if(!answer[index]){
                        
                        score++;
                    }
                    
                        index++;
                        
                        if(index<=answerLength){
                            
                    show.setText("Q:"+index +1+ " "+questions[index]);
                        
                          }else{
                              
                            Yes.setEnabled(false);
                            
                            No.setEnabled(false);
                            ResetQuiz.setEnabled(true);
                            
                            if(score  <= answerLength)
                            show.setText("Your correct answer is : "+score);
                            else
                            show.setText("Wow Congratulations 👏🎉 your all answer is correct");
                            
                            
                          }
                }
                    }
                
                
                
                
                
        });
        
        
    }
    
    public void resetQuiz(){
        
        
        quiz();
        
        
    }
    
    
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
    
    
    
    
}
