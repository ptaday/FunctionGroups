
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BijectionGroup {

    public static void main(String... args) {


        Set<Integer> a_few = Stream.of(1, 2, 3).collect(Collectors.toSet());
        List<Function<Integer, Integer>> bijections = bijectionsOf(a_few);

        bijections.forEach(aBijection -> {
            a_few.forEach(n -> System.out.printf("%d --> %d; ", n, aBijection.apply(n)));
            System.out.println();
        });

        System.out.println();


            Group<Function<Integer,Integer>> g = bijectionGroup(a_few);
            Function<Integer,Integer>f1 = bijectionsOf(a_few).stream().findFirst().get();
            Function<Integer,Integer> f2 = g.inverseOf(f1);
            Function<Integer,Integer> id = g.identity();

            a_few.forEach(n -> System.out.printf("%d --> %d; ", n, f1.apply(n)));
            System.out.println();
            a_few.forEach(n -> System.out.printf("%d --> %d; ", n, f2.apply(n)));
            System.out.println();
            a_few.forEach(n -> System.out.printf("%d --> %d; ", n, id.apply(n)));

        }




    public static <T> List<Function<T,T>> bijectionsOf(Set<T> domain){


        T[] domainArray = (T[]) domain.toArray();
        List<List<T>> collectionOfList=new ArrayList<>();

        for(int i=0;i< domain.size();i++)
        {
            List<T> newDomain=new ArrayList<>();
            T variable=domainArray[i];
            List<T> variableSet=new ArrayList<T>();
            variableSet.add(variable);

            for(int j=0;j< domainArray.length;j++)
            {
                if(!variable.equals(domainArray[j]))
                    newDomain.add(domainArray[j]);
            }

            List<List<T>> newSet=new ArrayList<>();
            List<List<T>> temp=bijectionsOfHelper(domain,newSet, variableSet,newDomain);

           for(int z=0;z< temp.size();z++)
            collectionOfList.add(temp.get(z));
        }
        List<Function<T,T>> list=new ArrayList<Function<T,T>>();

        for(int i=0;i< collectionOfList.size();i++)
        {
            int finalI = i;
            Function<T,T> one=new Function<T, T>() {
            @Override
            public T apply(T t) {
                HashMap<T,T> map=new HashMap<>();


                for(int i=0;i<domainArray.length;i++)
                {
                    map.put(domainArray[i],collectionOfList.get(finalI).get(i));
                }

                T value= map.get(t);

              return value;
            }
        };
           list.add(one);
        }

        return list;
    }

    public static <T> List<List<T>> bijectionsOfHelper(Set<T> ogSet, List<List<T>> setToBeReturned, List<T>head, List<T> remaining)
    {
        T[] remainingArray= (T[]) remaining.toArray();
        T[] headArray= (T[]) head.toArray();
        for(int i=0; i<remaining.size();i++)
        {
            List<T> newIterableSet=new ArrayList<>();


            for(int j=0;j< headArray.length;j++)
                newIterableSet.add(headArray[j]);

            newIterableSet.add(remainingArray[i]);

            if(remaining.size()==1) {
                setToBeReturned.add(newIterableSet);
            }

            else {
                List<T> newRemainingSet=remainingSetUpdater(ogSet,newIterableSet);
                bijectionsOfHelper(ogSet,setToBeReturned,newIterableSet,newRemainingSet);
            }
        }
        return setToBeReturned;
    }

    public static <T>List<T> remainingSetUpdater(Set<T>originalSet,List<T>goodSet)
    {
        T[] originalSetArray= (T[]) originalSet.toArray();
        T[] goodSetArray= (T[]) goodSet.toArray();

        List<T> toBeReturned=new ArrayList<>();

        for(int i=0;i<originalSetArray.length;i++)
        {
            T current=originalSetArray[i];

            int c=0;

            for(int j=0;j<goodSetArray.length;j++)
            {
                if(current.equals(goodSetArray[j])) {
                    c=1;
                    break;
                }
            }

            if(c==0)
                toBeReturned.add(current);
        }

        return toBeReturned;
    }

    public static <T> Group<Function<T,T>> bijectionGroup(Set<T> domain)
    {
       List<Function<T,T>> functionList= bijectionsOf(domain);
        T[] domainArray = (T[]) domain.toArray();

       Group<Function<T,T>> group=new Group<Function<T, T>>() {
           @Override
           public Function<T, T> binaryOperation(Function<T, T> one, Function<T, T> other) {
               return one.andThen(other);
           }

           @Override
           public Function<T, T> identity() {

               HashMap<T,T> map= new HashMap<>(); Function<T,T> toBeReturned=null;

               for(int i=0;i< domainArray.length;i++)
               map.put(domainArray[i],domainArray[i]);

               for(int i=0;i< functionList.size();i++)
               {
                   int c=0;
                   for(int j=0;j<domainArray.length;j++)
                   {

                      if(map.get(domainArray[j]).equals(functionList.get(i).apply(domainArray[j])))
                          c++;

                      else
                          break;

                   }

                   if(c==domainArray.length)
                  toBeReturned=functionList.get(i);
               }

               return toBeReturned;
           }

           @Override
           public Function<T, T> inverseOf(Function<T, T> ttFunction) {

               HashMap<T,T> map= new HashMap<>();

               Function<T,T> newFunction=new Function<T, T>() {
                   @Override
                   public T apply(T t) {
                       HashMap<T,T> map= new HashMap<>();

                       for(int i=0;i<domainArray.length;i++)
                       {
                           map.put(ttFunction.apply(domainArray[i]),domainArray[i]);
                       }

                       T value= map.get(t);

                       return value;
                   }
               };

             return newFunction;
           }
       };

       return group;
    }
}