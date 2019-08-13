public class Java_IC_Vs_Lambda {

    private String value = "Enclosing scope value";

    public String method(String string) {
        return this.value;
    }

    public String scopeExperiment() {

        Java8_Foo fooIC = new Java8_Foo() {

            String value = "Inner class value";
            @Override
            public String method(String string) {
                //return this.value;
                return value;
            }
        };
        String resultIC = fooIC.method("");

        Java8_Foo fooLambda = parameter -> {

            String value = "Lambda value";
            //return this.value;
            return value;
        };
        String resultLambda = fooLambda.method("");

        return "Results: resultIC = " + resultIC +
                ", resultLambda = " + resultLambda;
    }

    public static void main(String args[])
    {
        Java_IC_Vs_Lambda testObj = new Java_IC_Vs_Lambda();
        String s = testObj.scopeExperiment();

        System.out.println(s);
    }

}
