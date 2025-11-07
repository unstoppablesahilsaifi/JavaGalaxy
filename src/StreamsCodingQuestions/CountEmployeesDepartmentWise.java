package StreamsCodingQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountEmployeesDepartmentWise {
    public static void main(String[] args) {
        Map<String, String> emp = new HashMap<>();
        emp.put("Amit", "HR");
        emp.put("Sahil", "IT");
        emp.put("Riya", "HR");
        emp.put("Arun", "Sales");
        emp.put("Sneha", "IT");
        // Step  Use Stream to count employees department-wise
        Map<String, Long> departmentCount = emp.values().stream()
                .collect(Collectors.groupingBy(dept -> dept, Collectors.counting()));

        // Step Print result
        departmentCount.forEach((dept, count) ->
                System.out.println(dept + " : " + count));
    }
}
