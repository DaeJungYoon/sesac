package org.example.abstractprac.library;

public class Dvd extends Datas {
    public Dvd(String title, String id, boolean isLoan) {
        super(title, id, isLoan);
    }

    @Override
    public boolean loan() {
        return true;
    }

    @Override
    public boolean dataReturn() {
        return false;
    }
}
