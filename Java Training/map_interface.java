import java.util.*;
public class map_interface {

    static void hash_map(){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"Spain");
        hashMap.put(2, "Argentina");
        hashMap.put(3, "France");
        hashMap.put(3, "England");

        for(int i : hashMap.keySet()){
            System.out.print(i+" "+hashMap.get(i));
            System.out.println();
        }
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.get(1));

        HashSet<Integer> hashSet = new HashSet<>(hashMap.keySet());
        System.out.println(hashSet);

        HashSet<String> countryHashSet = new HashSet<>(hashMap.values());
        System.out.println(countryHashSet);

        Set <Map.Entry<Integer,String>> entries = hashMap.entrySet();
        for(Map.Entry<Integer,String> y : entries){
            System.out.println(y.getKey()+" "+y.getValue());
        }
    }
    public static void main(String[] args) {
        hash_map();
    }
}
