import java.util.*;
public class collection {
    /*
    HASHSET -(No insertion order but unique values)
    It is a implemented class of set interface,which is present in java.util package.
    The default capacity is 16.We cannot store duplicate data in the hashset.
    Internal data structure is HashMap and internally hashmap is using hashtable.
    Insertion order is not maintained in hashset,because data is stored on the basis of hashcode.
    When we are inserting a data, node is going to be created,inside node we are having key, value and next.
    In key we are storing the day, in value it will be dummy and in next whenever different data is getting a same index
    that situation is called as collision. To handle a collision we are making use of next.
    Fastest for TimeComplexity

    LINKED HASHSET -(Insertion order with unique values)
    Default capacity is 16. The Internal data structure of Linked hash set is linked list and hashmap.
    When we are inserting a data.One object is going to be created, which is having 5 fields,
    1.Key - Stores actual value
    2.Value - Stores a dummy
    3.Before - Stores address of the previous node
    4.After - Stores address of the next node
    5.Next - End of the node
    Because of LinkedList the insertion order is maintained.
    Because of Hashmap its will accept only unique values.

    TreeSet
    The internal data structure of TreeSet is Binary Search Tree.Inside the tree set we cannot insert null values.
    We cannot insert duplicate data as well.It is performing in-order traversal,where it will check left and right parents.
    We will get data in ascending order.

    Queue
    It is a implemented class of Queue interface, which is present in java.util package.
    The internal data structure for priority queue is HEAP. By default it is using MIN-HEAP
    It is not following the insertion order but always first element should be the smallest of em all.
    While removing the data,you will get the output in ascending order.

    Comparable
    It is an interface present inside java.lang package.
    Inside the comparable interface, we are having a method that is compareto method.
    We are using comparable interface, for doing natural sorting of any object on the basis of their properties.
    We cannot compare non-primitive values by using == operator.If we will make use of equals() method it will return the
    boolean value on the basis of that we cannot do sorting.
    We have to override compareto method in such a way that:
    1.If object one is greater than object two,it will return positive data.
    2.If current object is lesser than past object, it will return negative data.
    3.If both the objects are equal , we get 0.

    How to use comparable:
    1.We have to create an object of comparable type.
    2.Override compareto method
    3.Calling Collections.Sort()

    */
   class Student{
    int id;
    String name;
    double marks;
    public Student(int id, String name,double mark){
        this.name = name;
        this.id = id;
        this.marks = mark;
    }
    void print(){
        System.out.println("My name is "+name);
        System.out.println("My id is: "+id);
        System.out.println("My Marks are: "+marks);
    }
    public int compareTo(Object o){
        Student s = (Student) o;
        return this.name.compareTo(s.name);
    }
   }

   public static void main(String[] args) {
    //NO insertion order maintained
        HashSet<Integer> h = new HashSet<Integer>();
        h.add(10);
        h.add(20);
        h.add(30);
        h.add(20);
        // System.out.println(h);
    //Insertion order maintained
        LinkedHashSet<Integer> lh = new LinkedHashSet<>();
        lh.add(10);
        lh.add(20);
        lh.add(30);
        lh.add(20);
        // System.out.println(lh);
    //TreeSet Binary search tree
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(1);
        treeSet.add(9);
        treeSet.add(13);
        // System.out.println(treeSet);
    //Floor method - Returns the nearest lower value
    //     System.out.println(treeSet.floor(13));
    //     System.out.println(treeSet.floor(12));
    //Ceiling method - Returns the nearest greater value
    //     System.out.println(treeSet.ceiling(8));
    //     System.out.println(treeSet.ceiling(9));
    //Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(30);
        queue.add(10);
        queue.add(20);
        queue.add(50);
        queue.add(15);
        // System.out.println(queue);
        queue.remove(30);
        // System.out.println(queue);
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // System.out.println(queue);


        PriorityQueue<Integer> prior = new PriorityQueue<>();
        prior.offer(10);
        prior.offer(75);
        prior.offer(25);
        prior.offer(50);
        prior.offer(35);
        // while(!prior.isEmpty()){
        //     System.out.println(prior.poll());
        // }
        // System.out.println(prior);

        ArrayDeque<Integer> queue2 = new ArrayDeque<>();
        queue2.push(10);
        queue2.push(30);
        queue2.pop();


        ArrayDeque<Integer> queue3 = new ArrayDeque<>();
        queue3.offer(10);
        queue3.offer(20);
        queue3.offer(55);        

        // System.out.println(queue3.poll());
        // System.out.println(queue3);


   }

}
