package ru.geekbrains.lessions2345.comparefastserialization.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.lessions2345.comparefastserialization.R;
import ru.geekbrains.lessions2345.comparefastserialization.logic.SendObjectParcelable;
import ru.geekbrains.lessions2345.comparefastserialization.logic.SendObjectSerializable;
import ru.geekbrains.lessions2345.comparefastserialization.logic.SendObjectSerializableVERYFAST;

public class MainActivitySecond extends AppCompatActivity {

    final int REQUEST_CODE = 111;
    final String LOG_TAG = "myLogs"; // Ключ нужен для ведения логирования (ЭТО НЕ ОБЯЗАТЕЛЬНО)
    TextView textView;
    long deltaWriteTime;
    long deltaReadTime;
    long curDelta;
    int loopsCounter;
    int maxReloads;
    int reloadCounter;
    Intent intent;
    SendObjectSerializableVERYFAST sendObjectSerializableVERYFAST;
    SendObjectParcelable sendObjectParcelable;
    SendObjectSerializable sendObjectSerializable;
    int numberReloads;
    String resultText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        textView = findViewById(R.id.show_result);



/*
        // Получение из intent класса sendObjectSerializableVERYFAST
        deltaWriteTime = (long) getIntent().getLongExtra("EndWriteTime", -1);
        deltaReadTime = System.nanoTime();
        SendObjectSerializableVERYFAST sendObjectSerializableVERYFAST = (SendObjectSerializableVERYFAST) getIntent().getSerializableExtra("UniqueKey_4");
        deltaReadTime = System.nanoTime() - deltaReadTime;
        deltaWriteTime = deltaWriteTime - sendObjectSerializableVERYFAST.getTime();
*/



/*
        // Получение из intent класса sendObjectParcelable
        deltaWriteTime = (long) getIntent().getLongExtra("EndWriteTime", -1);
        deltaReadTime = System.nanoTime();
        SendObjectParcelable sendObjectParcelable = (SendObjectParcelable) getIntent().getParcelableExtra("UniqueKey_4");
        deltaReadTime = System.nanoTime() - deltaReadTime;
        deltaWriteTime = deltaWriteTime - sendObjectParcelable.getTime();
*/





        // Получение из intent класса sendObjectSerializable
        deltaWriteTime = (long) getIntent().getLongExtra("EndWriteTime", -1);
        deltaReadTime = System.nanoTime();
        SendObjectSerializable sendObjectSerializable = (SendObjectSerializable) getIntent().getSerializableExtra("UniqueKey_4");
        deltaReadTime = System.nanoTime() - deltaReadTime;
        deltaWriteTime = deltaWriteTime - sendObjectSerializable.getTime();




        // ОБЩИЙ БЛОК
        curDelta = (long) getIntent().getLongExtra("CurDelta", -1);
        curDelta += deltaReadTime + deltaWriteTime;
        loopsCounter = (int) getIntent().getIntExtra("LoopsCounter", -1);
        reloadCounter = (int) getIntent().getIntExtra("ReloadCounter", -1) - 1;
        numberReloads = (int) getIntent().getIntExtra("NUMBER_RELOADS", -1);
        resultText = (String) getIntent().getStringExtra("ResultText");
        if (reloadCounter <= 0)
        {
            loopsCounter--;
            reloadCounter = numberReloads;
            // Здесь сделать добавление в текстовую переменную новых результатов
            resultText = String.valueOf(loopsCounter + 1) + ") " + String.valueOf(curDelta / numberReloads) + " нс.\n" + resultText;
            curDelta = 0;
        }
        if (loopsCounter > 0)
        {
            // Запись данных и переход обратно на активити MainActivity
            writeDatesAndGo();
        }
//        numberReloads = (int) getIntent().getIntExtra("NUMBER_RELOADS", -1);
        textView.setText(resultText);
    }

    private void writeDatesAndGo()
    {
        // Запись в intent класса sendObjectSerializable
        intent = new Intent(MainActivitySecond.this, MainActivity.class);
        intent.putExtra("CurDelta", curDelta);
        intent.putExtra("LoopsCounter", loopsCounter);
        intent.putExtra("ReloadCounter", reloadCounter);
        intent.putExtra("ResultText", resultText);

//        startActivity(intent);
        setResult(REQUEST_CODE, intent);
        finish();
    }
}