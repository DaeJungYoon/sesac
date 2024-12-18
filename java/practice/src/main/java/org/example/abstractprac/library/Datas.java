package org.example.abstractprac.library;

public abstract class Datas {
    public String title;
    public String id;
    public boolean isLoan;

    public Datas(String title, String id, boolean isLoan) {
        this.title = title;
        this.id = id;
        this.isLoan = false;
    }

    public abstract boolean loan();
  public abstract boolean dataReturn();
}
