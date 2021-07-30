package ru.geekbrains.lessions2345.comparefastserialization.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.lessions2345.comparefastserialization.R;
import ru.geekbrains.lessions2345.comparefastserialization.logic.NewObjectSerializableSimple;
import ru.geekbrains.lessions2345.comparefastserialization.logic.SendObjectParcelable;
import ru.geekbrains.lessions2345.comparefastserialization.logic.SendObjectSerializable;
import ru.geekbrains.lessions2345.comparefastserialization.logic.SendObjectSerializableVERYFAST;

public class MainActivity extends AppCompatActivity {

    final int ARRAY_SIZE = 64000;
    final int NUMBER_GLOBAL_LOOPS = 30;
    final int NUMBER_RELOADS = 10000;
    final int REQUEST_CODE = 111;

    Button button2;
    SendObjectSerializableVERYFAST sendObjectSerializableVERYFAST;
    SendObjectParcelable sendObjectParcelable;
    SendObjectSerializable sendObjectSerializable;
    long curTime;
    Intent intent;
    long curDelta;
    int loopsCounter;
    int reloadCounter;
    String resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.button_fast);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loopsCounter = NUMBER_GLOBAL_LOOPS;
                reloadCounter = NUMBER_RELOADS;
                curDelta = 0;
                resultText = "";
                writeDatesAndGo();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE)
        {
            // Алгоритм зацикливания передачи информации между MainActivity и MainActivitySecond
            curDelta = (long) data.getLongExtra("CurDelta", -1);
            loopsCounter = (int) data.getIntExtra("LoopsCounter", -1);
            reloadCounter = (int) data.getIntExtra("ReloadCounter", -1);
            resultText = (String) data.getStringExtra("ResultText");
            writeDatesAndGo();
        }
    }

    private void writeDatesAndGo()
    {



/*
        // Запись в intent класса sendObjectSerializableVERYFAST
        sendObjectSerializableVERYFAST = new SendObjectSerializableVERYFAST("VERY FAST", 0, new NewObjectSerializable(ARRAY_SIZE));
        curTime = System.nanoTime();
        sendObjectSerializableVERYFAST.setTime(curTime);
        intent = new Intent(MainActivity.this, MainActivitySecond.class);
        intent.putExtra("UniqueKey_4", sendObjectSerializableVERYFAST);
*/





/*
        // Запись в intent класса sendObjectParcelable
        sendObjectParcelable = new SendObjectParcelable("         ", 0, new NewObjectParcelable(ARRAY_SIZE));
        curTime = System.nanoTime();
        sendObjectParcelable.setTime(curTime);
        intent = new Intent(MainActivity.this, MainActivitySecond.class);
        intent.putExtra("UniqueKey_4", sendObjectParcelable);
*/




        // Запись в intent класса sendObjectSerializable
        sendObjectSerializable = new SendObjectSerializable("         ", 0, new NewObjectSerializableSimple(ARRAY_SIZE));
        curTime = System.nanoTime();
        sendObjectSerializable.setTime(curTime);
        intent = new Intent(MainActivity.this, MainActivitySecond.class);
        intent.putExtra("UniqueKey_4", sendObjectSerializable);



        // ОБЩИЙ БЛОК
        intent.putExtra("EndWriteTime", System.nanoTime());
        intent.putExtra("CurDelta", curDelta);
        intent.putExtra("LoopsCounter", loopsCounter);
        intent.putExtra("ReloadCounter", reloadCounter);
        intent.putExtra("NUMBER_RELOADS", NUMBER_RELOADS);
        intent.putExtra("ResultText", resultText);

//        startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE);
    }
}