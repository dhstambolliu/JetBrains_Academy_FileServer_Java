package client;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

public class Message implements Serializable {
    public String response;
    public String cmd;
    public String filename;
    public String newName;
    public int nameOrId;
    public int id;
    public byte[] content;
    public Message() {
        cmd = "";
        response = "";
        filename = "";
        newName = "";
        nameOrId = 0;
        id = -1;
        content = null;
    }
    public Message(Message copy) {
        this.cmd = copy.cmd;
        this.filename = copy.filename;
        this.newName = copy.newName;
        this.nameOrId = copy.nameOrId;
        this.id = copy.id;
        this.content = copy.content;
        this.response = copy.response;
    }
    public void printMsg() {
        System.out.println("cmd " + cmd);
        System.out.println("filename " + filename);
        System.out.println("newName " + newName);
        System.out.println("nameOrId " + nameOrId);
        System.out.println("id " + id);
        System.out.println("content " + content);
        //System.out.println("len " + len);
    }

    public byte[] getBytes() {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(this);
            return boas.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
