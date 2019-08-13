import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Java8_Function {

    public static void main(String args[]){

        Function<Employee, String> funcEmpToString= (Employee e)-> {return e.getName();};
        Function<String,String> initialFunction= (String s)->s.substring(0,(s.indexOf(' ')!=-1)?s.indexOf(' '):-1);
        Function<String,Integer> thirdFunction= (String s)->s.length();

        List<Employee> employeeList=
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));



        //List<String> empNameListInitials=convertEmpListToNamesList(employeeList, funcEmpToString.andThen(initialFunction));
        //empNameListInitials.forEach(str->{System.out.print(" "+str);});

        List<Integer> empNameListNamesLength = convertEmpListToNamesList(employeeList, funcEmpToString.andThen(initialFunction.andThen(thirdFunction)));
        List<Integer> empNameListNamesLength2 = convertEmpListToNamesList(employeeList, funcEmpToString.andThen(initialFunction).andThen(thirdFunction));

        empNameListNamesLength.forEach(str->{System.out.print(" "+str);});


    }
    public static List<Integer> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, Integer> fxN){

        List<Integer> empNameList = new ArrayList<>();
        for(Employee emp:employeeList){
            empNameList.add(fxN.apply(emp));
        }
        return empNameList;
    }

    private static class Employee {

        String name;
        int age;

        Employee(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}