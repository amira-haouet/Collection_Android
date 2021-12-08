package com.example.productmanagerwithui;


public class Etudiant {
    Integer id;
    String Fname;
    String Sname;
    String Cls;

    public Etudiant(Integer id, String fname, String sname, String cls) {
        this.id = id;
        Fname = fname;
        Sname = sname;
        Cls = cls;
    }

    public Etudiant( String fname, String sname, String cls) {
        Fname = fname;
        Sname = sname;
        Cls = cls;
    }
    public Etudiant() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getCls() {
        return Cls;
    }

    public void setCls(String cls) {
        Cls = cls;
    }


}
