import java.util.*;
import java.util.stream.Collectors;

public class SimpleUtils {

    public static <T extends Comparable<T>> T least(Collection<T> items, boolean from_start) {

      return items
              .stream()
              .reduce((t1,t2)-> {

                  if(from_start)
                  return t1.compareTo(t2)<0?t1:t2;

                          else {
                              if(t1.compareTo(t2)==0)
                                  return t2;

                             else
                      return (t1.compareTo(t2) <= 0 ? t1 : t2);
                  }
              })
              .orElse(null);

    }

    public static <K, V> List<String> flatten(Map<K, V> aMap) {
       return  aMap
                .entrySet()
                .stream()
                .map(element->element.getKey().toString()+"->"+element.getValue().toString())
                .collect(Collectors.toList());


    }

    public static void main(String[] args) {

            Collection<Integer> items = new ArrayList<>();
            items.add(3);
            items.add(1);
            items.add(8);
            items.add(1);
            items.add(11);
            System.out.println(least(items,false));


            HashMap<String,String> map=new HashMap<>();

            map.put("1","one");
            map.put("2","two");
            map.put("3","three");
            map.put("4","four");
            map.put("5","five");

            for(int i=0;i< map.size();i++)
                System.out.println(flatten(map).stream().collect(Collectors.toList()).get(i));

    }

}
