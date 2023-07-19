package arithmetic;

import core.Group;

public class FiniteGroupOfOrderTwo implements Group<PlusOrMinusOne> {

    PlusOrMinusOne plusOne=new PlusOrMinusOne(1);
    PlusOrMinusOne minusOne=new PlusOrMinusOne(-1);


    @Override
    public PlusOrMinusOne binaryOperation(PlusOrMinusOne x, PlusOrMinusOne y) {
       return new PlusOrMinusOne(x.number*y.number);
    }

    @Override
    public PlusOrMinusOne identity() {
        return plusOne;
    }

    @Override
    public PlusOrMinusOne inverseOf(PlusOrMinusOne x) {
            return x;
    }

    @Override
    public PlusOrMinusOne exponent(PlusOrMinusOne x, int k) {
        return Group.super.exponent(x,k);
    }

}