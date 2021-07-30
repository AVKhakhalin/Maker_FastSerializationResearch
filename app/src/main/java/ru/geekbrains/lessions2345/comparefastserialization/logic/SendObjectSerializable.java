package ru.geekbrains.lessions2345.comparefastserialization.logic;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class SendObjectSerializable implements Serializable {

    private String name;
    private long time;
    private NewObjectSerializableSimple newObjectSerializableSimple;

    public SendObjectSerializable(String name, long time, NewObjectSerializableSimple newObjectSerializableSimple) {
        this.name = name;
        this.time = time;
        this.newObjectSerializableSimple = newObjectSerializableSimple;
    }

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

    public NewObjectSerializableSimple getNewObjectSerializableSimple()
    {
        return newObjectSerializableSimple;
    }

}
