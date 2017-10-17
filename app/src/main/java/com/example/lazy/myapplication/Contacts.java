package com.example.lazy.myapplication;

/**
 * Created by Lazy on 8/28/2016.
 */
public class Contacts {
    private String ID, Num, Lic, Loc, BB, Model, Comm, MaPaSe, Date;

    public Contacts(String ID, String Num, String Lic, String Loc, String BB, String Model, String Comm, String MaPaSe, String Date){
        this.setID(ID);
        this.setNum(Num);
        this.setLic(Lic);
        this.setLoc(Loc);
        this.setBB(BB);
        this.setModel(Model);
        this.setComm(Comm);
        this.setMaPaSe(MaPaSe);
        this.setDate(Date);
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public String getLic() {
        return Lic;
    }

    public void setLic(String lic) {
        Lic = lic;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBB() {
        return BB;
    }

    public void setBB(String BB) {
        this.BB = BB;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getComm() {
        return Comm;
    }

    public void setComm(String comm) {
        Comm = comm;
    }

    public String getMaPaSe() {
        return MaPaSe;
    }

    public void setMaPaSe(String maPaSe) {
        MaPaSe = maPaSe;
    }
}
