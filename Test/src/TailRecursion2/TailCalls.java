package TailRecursion2;

public class TailCalls {

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