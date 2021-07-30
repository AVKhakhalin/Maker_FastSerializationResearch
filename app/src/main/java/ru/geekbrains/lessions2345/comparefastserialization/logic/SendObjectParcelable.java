package ru.geekbrains.lessions2345.comparefastserialization.logic;

import android.os.Parcel;
import android.os.Parcelable;

public class SendObjectParcelable implements Parcelable {
    private String name;
    private long time;
    private NewObjectParcelable newObjectParcelable;

    public SendObjectParcelable(String name, long time, NewObjectParcelable newObjectParcelable) {
        super();
        this.name = name;
        this.time = time;
        this.newObjectParcelable = newObjectParcelable;
    }

    protected SendObjectParcelable(Parcel in) {
        name = in.readString();
        time = in.readLong();
        newObjectParcelable = in.readParcelable(NewObjectParcelable.class.getClassLoader());
    }

    public static final Creator<SendObjectParcelable> CREATOR = new Creator<SendObjectParcelable>() {
        @Override
        public SendObjectParcelable createFromParcel(Parcel in) {
            return new SendObjectParcelable(in);
        }

        @Override
        public SendObjectParcelable[] newArray(int size) {
            return new SendObjectParcelable[size];
        }
    };

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public NewObjectParcelable getNewObjectParcelable()
    {
        return newObjectParcelable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(time);
        dest.writeParcelable(newObjectParcelable, flags);
    }
}
