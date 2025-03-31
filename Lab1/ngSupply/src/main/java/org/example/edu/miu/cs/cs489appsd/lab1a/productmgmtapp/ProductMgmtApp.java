package org.example.edu.miu.cs.cs489appsd.lab1a.productmgmtapp;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMgmtApp {

    public static void main(String[] args) throws Exception {
        List<Product> productList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        productList.add(new Product(3128874119L, "Banana", sdf.parse("2023-01-24"), 124, 0.55));
        productList.add(new Product(2927458265L, "Apple", sdf.parse("2022-12-09"), 18, 1.09));
        productList.add(new Product(39189927460L, "Carrot", sdf.parse("2023-03-31"), 89, 2.99));

        // Sort by unit price descending
        List<Product> sortedList = productList.stream()
                .sorted(Comparator.comparingDouble(Product::getUnitPrice).reversed())
                .collect(Collectors.toList());

        listPrinter(sortedList);
    }

    private static void listPrinter(List<Product> sortedList) throws JsonProcessingException {
        // JSON Output
        ObjectMapper jsonMapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        for (Product product : sortedList) {
            String json = jsonMapper.writeValueAsString(product);
            sb.append(json).append("\n");
        }
        String jsonOutput = sb.toString();
        System.out.println("=== JSON Output ===");
        System.out.println(jsonOutput);

        // XML Output
        sb = new StringBuilder();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        for (Product product : sortedList) {
            String json = xmlMapper.writeValueAsString(product);
            sb.append(json).append("\n");
        }
        String xmlOutput = sb.toString();

        System.out.println("\n=== XML Output ===");
        System.out.println(xmlOutput);
    }
}