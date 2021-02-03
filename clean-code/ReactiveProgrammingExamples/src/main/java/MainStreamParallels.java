import java.util.ArrayList;
import java.util.List;

public class MainStreamParallels {
    public static void main(String[] args) {
        long timeBefore;
        long timeAfter;
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < 100; i++) {
            employees.add(new Employee("Employee"+i ,300));
            employees.add(new Employee("Employee"+i ,100));
            employees.add(new Employee("Employee"+i ,500));
            employees.add(new Employee("Employee"+i ,250));
            employees.add(new Employee("Employee"+i ,310));
            employees.add(new Employee("Employee"+i ,420));
            employees.add(new Employee("Employee"+i ,150));
            employees.add(new Employee("Employee"+i ,400));
        }
        timeBefore = System.currentTimeMillis();
        System.out.println("Secuential stream count :" +
                employees.stream().filter(employee -> employee.getSalary()>200).count());
        timeAfter = System.currentTimeMillis();
        System.out.println("Secuencial tiem taken:" + (timeAfter - timeBefore));

        //mayor rendimiento por que gestiona los hilos ejemplo 1
        /*timeBefore = System.currentTimeMillis();
        System.out.println("Parallel stream count :" +
                employees.parallelStream().filter(employee -> employee.getSalary()>200).count());
        timeAfter = System.currentTimeMillis();
        System.out.println("Parallel tiem taken:" + (timeAfter - timeBefore));*/

        //mayor rendimiento por que gestiona los hilos ejemplo 2
        timeBefore = System.currentTimeMillis();
        System.out.println("Parallel1 stream count :" +
                employees.parallelStream().filter(employee -> employee.getSalary()>200).parallel().count());
        timeAfter = System.currentTimeMillis();
        System.out.println("Parallel1 tiem taken:" + (timeAfter - timeBefore));
    }
}
