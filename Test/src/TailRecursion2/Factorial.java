package TailRecursion2;

public class Factorial{

    public static TailCall factorialTailRec(final int factorial, final int number) {
        if (number == 1)
            return done(factorial);
        else
        {
            TailCall x = call( () -> factorialTailRec(factorial * number, number - 1));

            //TailCall y = factorialTailRec(factorial * number, number - 1);

            return x;
        }
    }

    public static void main(String args[]){

        System.out.println(factorialTailRec(1, 5).invoke());

    }

    public static TailCall call(final TailCall nextCall) {
        return nextCall;
    }

    public static TailCall done(final int value) {

        return new TailCall() {
            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public int result() {
                return value;
            }

            @Override
            public TailCall apply() {
                throw new Error("not implemented");
            }
        };
    }
}