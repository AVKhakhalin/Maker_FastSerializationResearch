package ru.geekbrains.lessions2345.comparefastserialization.logic;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class NewObjectSerializable implements Serializable
{
    int first = 10;
    double[] arrayValue;

    public NewObjectSerializable()
    {
        super();
    }

    public NewObjectSerializable(int first, double[] arrayValue) {
        super();
        this.first = first;
        for (int i = 0; i < arrayValue.length; i++) {
            this.arrayValue[i] = arrayValue[i];
        }
    }

    public NewObjectSerializable(int maxNumber)
    {
        super();
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

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {
        out.writeInt(first);
        out.writeInt(arrayValue.length);
        for (int i = 0; i < arrayValue.length; i++) {
            out.writeDouble(arrayValue[i]);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        first = in.readInt();
        int lenArray = in.readInt();
        arrayValue = new double[lenArray];
        for (int i = 0; i < lenArray; i++) {
            arrayValue[i] = in.readDouble();
        }
    }

    private void readObjectNoData() throws ObjectStreamException
    {
    }
}
