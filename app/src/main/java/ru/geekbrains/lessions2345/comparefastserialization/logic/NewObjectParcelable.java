package ru.geekbrains.lessions2345.comparefastserialization.logic;

import android.os.Parcel;
import android.os.Parcelable;

public class NewObjectParcelable implements Parcelable
{
    int first = 10;
    double[] arrayValue;

    public NewObjectParcelable(int maxNumber)
    {
        arrayValue = new double[maxNumber];
        for (int i = 0; i < maxNumber; i++)
        {
            arrayValue[i] = i;
        }
    }

    protected NewObjectParcelable(Parcel in) {
        first = in.readInt();
        arrayValue = in.createDoubleArray();
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public static final Creator<NewObjectParcelable> CREATOR = new Creator<NewObjectParcelable>() {
        @Override
        public NewObjectParcelable createFromParcel(Parcel in) {
            return new NewObjectParcelable(in);
        }

        @Override
        public NewObjectParcelable[] newArray(int size) {
            return new NewObjectParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(first);
        dest.writeDoubleArray(arrayValue);
    }
}
