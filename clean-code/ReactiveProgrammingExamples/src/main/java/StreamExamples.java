import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    Stream<String> employees = listaEmpleados().stream();
    Stream<List<String>> employeesTwo = Stream.of(listaEmpleados());
     public List<String> listaEmpleados(){
         List<String> alist=new ArrayList<String>();
        alist.add("Steve");
        alist.add("Tim");
        alist.add("Lucy");
        alist.add("Pat");
        alist.add("Angela");
        alist.add("Tom");
        return alist;
    }
    public void peek(){
         employees.filter((employee)->employee.length()>3)
            .peek((employee)->showEmployee(employee));
    }
    public void foreach(){
         employees.forEach((employe)->showEmployee(employe));
    }

    public String convertToUppercase(String employee){
         return employee.toUpperCase();
    }

    private void showEmployee(String employ) {
        System.out.println(employ);
    }

    public void map(){
         employees.map(employee->convertToUppercase(employee))
                 .forEach(employee->showEmployee(employee));
    }


    public void skip(){
        employees.skip(3)
        .forEach(employees->showEmployee(employees));
    }
    public void limits(){
        employees.limit(3)
                .forEach(employees->showEmployee(employees));
    }

    public void intStreamSpecialization(){
       int valueMin = IntStream.of(2,4,6,8)
                    .min().getAsInt();
       showValues(valueMin);
       showValues(IntStream.range(0,15).sum());
        showValues(IntStream.of(0,1,2,2,6).distinct().reduce(0,Integer::sum));
        showValues(IntStream.of(0,1,2,2,6).distinct().reduce(0,(a,b)->a+b));
        showValues(IntStream.of(2,2,4,6).allMatch((numero)->numero % 2 == 0));
        showValues(IntStream.of(2,2,4,6).anyMatch((numero)->numero % 2 == 0));
        showValues(IntStream.of(2,2,4,6).noneMatch((numero)->numero % 2 == 0));
    }
    public void intStreamSpecializationDistinct(){
        long resultDistinctCount = IntStream
                .of(2,2,3,4,4,5,6,6,6,4,6,8)
                .distinct()
                .count();

        showValues(Integer.valueOf((int) resultDistinctCount));
    }

    public void showValues(int input){
        System.out.println(input);
    }

    public void showValues(boolean input){
        System.out.println(input);
    }

    public void generateStream(){
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
    public void iteratorStream(){
        Stream.iterate(4,(i)->i*4)
                .limit(10)
                .forEach(System.out::println);
    }

    public void flatMapStream(){
        List<Integer> listOne = Arrays.asList(1,2,3);
        List<Integer> listSecond = Arrays.asList(4,5);
        List<Integer> listThird = Arrays.asList(6,7,8,9);

        List<List<Integer>> listOfInts = Arrays.asList(listOne,listSecond,listThird);
        System.out.println(listOfInts);

        List<Integer> listOfIntsFlatMap = listOfInts
                .stream()
                .flatMap((list)->list.stream()).collect(Collectors.toList());
        System.out.println(listOfIntsFlatMap);
    }
}
