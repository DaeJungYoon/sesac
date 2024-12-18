package org.example.abstractprac.library;

public class Main {
  public static void main(String[] args) {
  Book book = new Book("king's road", "and23","h-1");
    book.loan();
    System.out.println(book.isLoan);

  }

}
