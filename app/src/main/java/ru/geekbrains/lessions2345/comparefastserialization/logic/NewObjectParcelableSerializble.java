package ru.geekbrains.lessions2345.comparefastserialization.logic;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.io.Serializable;

public class NewObjectParcelableSerializble implements Parcelable, Serializable
{
    int newNumber;

    public NewObjectParcelableSerializble(int newNumber)
    {
        this.newNumber = newNumber;
    }

    protected NewObjectParcelableSerializble(Parcel in) {
        newNumber = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(newNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NewObjectParcelableSerializble> CREATOR = new Creator<NewObjectParcelableSerializble>() {
        @Override
        public NewObjectParcelableSerializble createFromParcel(Parcel in) {
            return new NewObjectParcelableSerializble(in);
        }

        @Override
        public NewObjectParcelableSerializble[] newArray(int size) {
            return new NewObjectParcelableSerializble[size];
        }
    };

    public int getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(int newNumber) {
        this.newNumber = newNumber;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {
        out.writeInt(newNumber);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        newNumber = in.readInt();
    }
}
