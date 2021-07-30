package ru.geekbrains.lessions2345.comparefastserialization.logic;

import java.io.Serializable;

public class NewObjectSerializableSimple implements Serializable
{
    int first = 10;
    double[] arrayValue;

    public NewObjectSerializableSimple(int maxNumber)
    {
        arrayValue = new double[maxNumber];
        for (int i = 0; i < maxNumber; i++)
        {
            arrayValue[i] = i;
        }
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
}
