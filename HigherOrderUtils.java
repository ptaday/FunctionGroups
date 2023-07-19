import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class HigherOrderUtils {

    static interface NamedBiFunction<T,U,R> extends java.util.function.BiFunction {
       String name();

        }

       public static NamedBiFunction add= new NamedBiFunction(){
            String name="plus";
            @Override
            public String name() {
                return name;
            }

            @Override
            public Object apply(Object o, Object o2) throws IllegalArgumentException{

                if (o instanceof Number && o2 instanceof Number) {
                    Double d1 = (Double) o;
                    Double d2 = (Double) o2;

                    return d1 + d2;
                }
                else
                    throw new IllegalArgumentException("Not a number type.");
            }
        };

    public static NamedBiFunction subtract= new NamedBiFunction() {
        String name="minus";

        @Override
        public String name() {
            return name;
        }

        @Override
        public Object apply(Object o, Object o2) throws IllegalArgumentException {

            if (o instanceof Number && o2 instanceof Number) {
                Double d1 = (Double) o;
                Double d2 = (Double) o2;

                return d2 - d1;
            }
            else
                throw new IllegalArgumentException("Not a number type.");
        }

    };

    public static NamedBiFunction multiply=new NamedBiFunction() {
        String name="mult";

        @Override
        public String name() {
            return null;
        }

        @Override
        public Object apply(Object o, Object o2) throws IllegalArgumentException {

            if (o instanceof Number && o2 instanceof Number) {
                Double d1 = (Double) o;
                Double d2 = (Double) o2;

                return d1 * d2;
            }
            else
                throw new IllegalArgumentException("Not a number type.");

        }
    };

    public static NamedBiFunction divide=new NamedBiFunction() {
        String name="div";
        @Override
        public String name() {
            return name;
        }

        @Override
        public Object apply(Object o, Object o2) throws ArithmeticException,IllegalArgumentException {

            if (o instanceof Number && o2 instanceof Number) {
                Double d1 = (Double) o;
                Double d2 = (Double) o2;

                if (d2.doubleValue() == 0.0)
                    throw new ArithmeticException("Cannot divide by zero.");
                else
                    return d1 / d2;
            } else
                throw new IllegalArgumentException("Not a number type.");
        }

    };


    public static <T> T zip(List<T> args, List<? extends BiFunction>bifunctions){

       /* Arrays.asList(-0.5, 2d, 3d, 0d, 4d), and
                * List<NamedBiFunction<Double, Double, Double>> bfs = Arrays.asList(add, multiply, add, divide)*/

        if(args.size()-bifunctions.size()==1)
        {
         for(int i=1;i<args.size();i++)
         {
             T d= (T) bifunctions.get(i-1).apply(args.get(i-1),args.get(i));

             args.set(i,d);
         }

         return args.get(args.size()-1);
        }
        else
        {
            throw new IllegalArgumentException("Invalid Entry.");
        }
    }

    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(-0.5, 2d, 3d, 0d, 4d); // documentation example
        List<NamedBiFunction<Double, Double, Double>> operations = Arrays.asList(add,multiply,add,divide);
        Double d = zip(numbers, operations); // expected correct value: 1.125
        System.out.println(d);

        List<String> strings = Arrays.asList("a", "n", "t");

        BiFunction<String, String, String> concat = (s, t) -> s + t;
        String s = zip(strings, Arrays.asList(concat, concat));
        System.out.println(s);
    }
}
