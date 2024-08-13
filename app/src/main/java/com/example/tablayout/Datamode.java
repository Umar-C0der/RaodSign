package com.example.tablayout;

public class Datamode  {

    String dis;
    byte[] image;

    public Datamode(String dis, byte[] image) {
        this.dis = dis;
        this.image = image;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
