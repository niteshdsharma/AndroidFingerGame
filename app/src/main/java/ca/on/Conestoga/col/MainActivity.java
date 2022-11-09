package ca.on.Conestoga.col;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button oneFinger;
    private Button twoFinger;
    private ImageButton leftImage;
    private ImageButton rightImage;
    private TextView txtResult;
    int myMove,compMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneFinger = findViewById(R.id.btnOne);
        twoFinger = findViewById(R.id.btnTwo);

        leftImage = findViewById(R.id.imgBtnComp);
        rightImage = findViewById(R.id.imgBtnYou);

        txtResult = findViewById(R.id.textViewresult);

        oneFinger.setOnClickListener(this);
        twoFinger.setOnClickListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.fingergame_menu,menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {



         compMove= (int) ( Math.random() * 2 + 1);

         if(v.getId()==R.id.btnOne){

             myMove=1;
             rightImage.setImageResource(R.drawable.ic_one);


         }
         if(v.getId()==R.id.btnTwo){

             myMove=2;

             rightImage.setImageResource(R.drawable.ic_two);

         }

        if(compMove==1){
            leftImage.setImageResource(R.drawable.ic_one);
        }
        else{
            leftImage.setImageResource(R.drawable.ic_two);
        }

        showResult();

    }


    private  void showResult(){

         int  result = myMove+compMove;

         if(result%2==0){

             txtResult.setText("You Win");
         }else{
             txtResult.setText("Computer Win");
         }

         leftImage.setVisibility(View.VISIBLE);
         rightImage.setVisibility(View.VISIBLE);



    }



}