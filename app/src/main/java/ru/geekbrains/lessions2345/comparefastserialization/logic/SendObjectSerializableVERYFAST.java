package ru.geekbrains.lessions2345.comparefastserialization.logic;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class SendObjectSerializableVERYFAST implements Serializable {

    private String name;
    private long time;
    private NewObjectSerializable newObjectSerializable;

    public SendObjectSerializableVERYFAST()
    {
        super();
    }

    public SendObjectSerializableVERYFAST(String name, long time, NewObjectSerializable newObjectSerializable) {
        super();
        this.name = name;
        this.time = time;
        this.newObjectSerializable = newObjectSerializable;
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

    public NewObjectSerializable getNewObjectSerializable()
    {
        return newObjectSerializable;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {
        out.writeUTF(name);
        out.writeLong(time);
        out.writeObject(newObjectSerializable);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        name = in.readUTF();
        time = in.readLong();
        newObjectSerializable = (NewObjectSerializable) in.readObject();
    }

    private void readObjectNoData() throws ObjectStreamException
    {
    }
}
