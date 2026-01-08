package service; import util.*;import java.util.*;
public class BookService{
 static List<Book>b=new ArrayList<>(); static final String F="data/books.csv";
 public static void load(){ b.clear(); List<String>l=CSVReader.read(F);
 for(int i=1;i<l.size();i++){String[]d=l.get(i).split(",");
 b.add(new Book(d[0],d[1],d[2],Integer.parseInt(d[3]),BookStatus.valueOf(d[4])));}}
 public static void save(){ List<String>d=new ArrayList<>();
 d.add("title,author,genre,year,status");
 for(Book x:b)d.add(x.getTitle()+","+x.getAuthor()+","+x.getGenre()+","+x.getYear()+","+x.getStatus());
 CSVWriter.write(F,d);}
 public static List<Book>all(){b.sort(Comparator.comparing(Book::getTitle));return b;}
 public static List<Book>byStatus(BookStatus s){return b.stream().filter(x->x.getStatus()==s).toList();}
}