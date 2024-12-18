package org.example.abstractprac.library;

public class Book extends Datas implements LocationUsable{
    protected String location;

    public Book(String title, String id,String location) {
        super(title, id, false);
        this.location = location;
    }

    @Override
    public boolean loan(){
        return isLoan = true;
    }

    @Override
    public boolean dataReturn(){
        return isLoan = false;
    }

    @Override
    public void locationInfo() {
        System.out.println(location);
    }
}
