package org.example.abstractprac.library;

public class EBook extends Datas implements DownloadUsable{
    public int downloadCount;

    public EBook(String title, String id, boolean isLoan) {
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

    @Override
    public void download() {
        downloadCount +=1;
    }
}
