package model;

import model.Book;
import model.User;

public class Loan{ User u; Book b;
 public Loan(User u,Book b){this.u=u;this.b=b;}
 public User getUser(){return u;} public Book getBook(){return b;}
}
