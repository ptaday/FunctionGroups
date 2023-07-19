package arithmetic;

import java.util.ArrayList;

public class PlusOrMinusOne  {

    int number;
    int counter=0;
    public static ArrayList<PlusOrMinusOne> listOfValues=new ArrayList<PlusOrMinusOne>();


    public PlusOrMinusOne()
    {
     number=0;
    }

    public PlusOrMinusOne(int number)
    {
        this.number=number;

        if(listOfValues.size()<=1)
        listOfValues.add(this);
    }

    public int getNumber() {
        return number;
    }

    public static PlusOrMinusOne[] values(){
      return listOfValues.toArray(new PlusOrMinusOne[2]);
    }

    @Override
    public String toString() {
        String s="";
        s=s+this.number;

        return s;
    }
}