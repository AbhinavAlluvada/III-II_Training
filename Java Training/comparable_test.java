
import java.util.*;
public class comparable_test {
    static class Student implements Comparable<Student>{
        int id;
        int marks;
        String name;
        Student(int id,int marks,String name){
            this.id = id;
            this.marks = marks;
            this.name = name;
        }
        @Override
        public int compareTo(Student s){
            return s.marks - this.marks;
        }
    }
    static class SortId implements Comparator<Object>{
        @Override
        public int compare(Object o1, Object o2){
            Student s1 = (Student)o1;
            Student s2 = (Student)o2;
            return s1.id - s2.id;
            
        }}
    static class SortName implements Comparator<Object>{
        @Override
        public int compare(Object o1,Object o2){
            Student s1 = (Student)o1;
            Student s2 = (Student)o2;
            return s1.name.compareTo(s2.name);
        }
    }
    static class SortMarks implements Comparator<Student>{
        @Override
        public int compare(Student s1,Student s2){
            return s1.marks - s2.marks;
        }
    }

    public static void main(String [] args){
        // Student s1 = new Student(90,"Annie");
        // Student s2 = new Student(99,"Robert");
        // System.out.println(s1.compareTo(s2));
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(110,94,"John"));
        list.add(new Student(102,52,"Sawyer"));
        list.add(new Student(105,96,"Jack"));
        list.add(new Student(104,99,"Desmond"));
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(choice.equals("marks")){
        Collections.sort(list,new SortMarks());
        for(Student s : list){
            System.out.println(s.id + " "+s.name+" "+s.marks);
        }
        }
        else if(choice.equals("name")){
        Collections.sort(list,new SortName());
        for(Student s : list){
            System.out.println(s.id + " "+s.name+" "+s.marks);
        }}
        else if(choice.equals("id")){
        Collections.sort(list,new SortId());
        for(Student s : list){
            System.out.println(s.id + " "+s.name+" "+s.marks);
        }   
        }
        
        else{
            System.out.println("No Valid Reference");
        }
        scanner.close();

        
    }
}
