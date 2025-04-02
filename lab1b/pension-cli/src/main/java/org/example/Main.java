package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.model.Employee;
import org.example.model.PensionPlan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
    public static void main(String[] args) throws ParseException, JsonProcessingException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee(
                1L,
                "Daniel",
                "Agar",
                sdf.parse("2018-01-17"),
                105945.50,
                new PensionPlan(
                        1089L,
                        sdf.parse("2023-01-17"),
                        100.00
                )
        );

        Employee employee2 = new Employee(
                2L,
                "Benard",
                "Shaw",
                sdf.parse("2018-10-03"),
                197750.00,
                null // No pension plan
        );

        Employee employee3 = new Employee(
                3L,
                "Carly",
                "Agar",
                sdf.parse("2014-05-16"),
                842000.75,
                new PensionPlan(
                        2307L,
                        sdf.parse("2019-11-04"),
                        1555.50
                )
        );

        Employee employee4 = new Employee(
                4L,
                "Wesley",
                "Schneider",
                sdf.parse("2018-11-02"),
                74500.00,
                null // No pension plan
        );

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        //1 print Employee List
        printEmployeeList(employees);

        //2 print Quaterly Upcoming Enrolles List
        printQualifiedEmployeeLIst(employees);
    }

    public static void printEmployeeList(List<Employee> employees) throws JsonProcessingException {
        List<Employee> sortedEmployees = employees
                .stream()
                .sorted(
                Comparator.comparing(Employee::getYearlySalary)
                        .thenComparing(Employee::getLastName)
                ).collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        String json = objectMapper.writeValueAsString(sortedEmployees);
        System.out.println("==< Employee List >==");
        System.out.println(json);

    }

    public static void printQualifiedEmployeeLIst(List<Employee> employees) throws JsonProcessingException {

        List<Employee> sortedEmployeeList = employees
                .stream()
                .filter(employee -> employee.getPensionPlan() == null)
                .filter(employee -> (new Date().getTime() - employee.getEmploymentDate().getTime())/(1000L * 60 * 60 * 24 * 365) >= 3)
                .sorted(
                        Comparator.comparing(Employee::getEmploymentDate)
                )
                .collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        String json = objectMapper.writeValueAsString(sortedEmployeeList);
        System.out.println("==< Quaterly Upcoming Enrolles List >==");
        System.out.println(json);
    }



}