import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting_SortObjectUsingComparator {

    public static void main(String args[]) {

        Employee e[] = new Employee[10];

        for (int i = 0; i <10 ; i++) {
            e[i] = new Employee( ".Name"+i, 1200*(i%3), 100+i);
        }

        /**Working*/empSort(e,10);
        //empSortByGrouping(e,10);
        /**Working*/empSort_and_Collect(e,10);
    }

    private static void empSort_and_Collect(Employee[] e, int n) {

        List<Employee> employeeList = Arrays.asList(e);

        List<Employee> collect = employeeList.stream()
                .sorted(new EmployeeComparator())
                .collect(Collectors.toList());


        for (int i = 0; i < n; i++) {
            System.out.println(collect.get(i).id + "\t\t" + collect.get(i).name + "\t" + collect.get(i).salary );
        }
    }

    static void empSortByGrouping(Employee e[],int n){

        ArrayList<Employee> employeeList = new ArrayList<>(Arrays.asList(e));

        //TODO: Read about flatMap : employeeList.stream().flatMapToLong()

        Map<Integer, Map<Integer, List<Employee>>> groupedEmployees = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getSalary,
        Collectors.groupingBy(Employee::getId)));

        Stream<Map.Entry<Integer, Map<Integer, List<Employee>>>> grEmpStream = groupedEmployees.entrySet().stream();
        Stream<Map<Integer, List<Employee>>> mapStream = grEmpStream.map(entry->entry.getValue());
        Stream<List<Employee>> empStream = mapStream.flatMap(m->m.entrySet().stream().map(xc->xc.getValue()));

        Stream<Employee> empStr = empStream.flatMap(SemL -> SemL.stream());

        Employee efe = empStr.filter(ef -> ef.salary.compareTo(1200)==0).findFirst().get();



        Integer a[] = {1,2,3};
        List<Integer> Ints = Arrays.stream(a).collect(Collectors.toList());
        List<Integer> Ints2 = Arrays.asList(a);
    }

    static void empSort(Employee e[],int n)
    {

        ArrayList<Employee> employeeList = new ArrayList<Employee>(Arrays.asList(e));

        Collections.sort(employeeList, new EmployeeComparator());

        for (int i = 0; i < n; i++) {
            System.out.println(employeeList.get(i).name + " " + employeeList.get(i).salary + " " + employeeList.get(i).id);
        }

    }

    static class EmployeeComparator implements Comparator<Employee>
    {
        @Override
        public int compare(Employee a, Employee b) {

            if(a.salary.compareTo(b.salary) == 0 )
            { return b.id - a.id; }
            else
            { return b.salary - a.salary; }
        }
    }

    private static class Employee {

        String name;
        Integer salary;
        Integer id;

        Employee(String name, Integer salary, Integer id) {
            this.name = name;
            this.salary = salary;
            this.id = id;
        }

        void print(){

            System.out.println(this.id +" - Mr" + this.name + ", $" + this.salary);
        }

        public String getName() {
            return name;
        }

        public Integer getSalary() {
            return salary;
        }

        public Integer getId() {
            return id;
        }
    }
}
