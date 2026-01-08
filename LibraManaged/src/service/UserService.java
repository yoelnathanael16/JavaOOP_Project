package service; import util.*;import java.util.*;
public class UserService{
 static List<User>u=new ArrayList<>(); static final String F="data/users.csv";
 public static void load(){u.clear(); List<String>l=CSVReader.read(F);
 for(int i=1;i<l.size();i++){String[]d=l.get(i).split(",");
 u.add(d[1].equals("ADMIN")?new Admin(d[0]):new Member(d[0]));}}
 public static List<User>all(){u.sort(Comparator.comparing(User::getName));return u;}
}