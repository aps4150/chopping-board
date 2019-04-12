public class Factorial{

    public static TailCall factorialTailRec(final int factorial, final int number) {
        if (number == 1)
            return TailCalls.done(factorial);
        else
            return TailCalls.call( () -> factorialTailRec(factorial * number, number - 1));
    }

    public static void main(String args[]){

        System.out.println(factorialTailRec(1, 3).invoke());

    }
}