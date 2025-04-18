package org.example;


import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("growing-adder-56856.upstash.io", 6379, true);
        jedis.auth("Ad4YAAIjcDEyODdlY2ZiODFmNDI0OWI0OWVhNTVlZjM2YmVjMGZlZnAxMA");

        // Load CSV and insert into Redis
        Path inputFile = Paths.get("C:\\Users\\DELL\\Downloads\\MOCK_DATA.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile.toFile()))) {
            String header = reader.readLine(); // Skip header
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null && count < 10000) {
                // Let's assume CSV columns: id,firstName,lastName,email,...
                String[] fields = line.split(",");
                if (fields.length < 2) continue;

                String id = fields[0];
                String firstName = fields[1];

                String key = "record:" + id;
                jedis.set(key, line);
                jedis.sadd("firstName:" + firstName.toLowerCase(), key); // For firstname search
                count++;
            }
            System.out.println(count + " records inserted into Redis.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // === Search by Key ===
        String searchKey = "record:100"; // example
        long startKey = System.nanoTime();
        String result = jedis.get(searchKey);
        long endKey = System.nanoTime();
        if (result != null) {
            System.out.println("Found by key: " + result);
        } else {
            System.out.println("No record found with key: " + searchKey);
        }
        System.out.println("Key search took: " + ((endKey - startKey) / 1_000_000.0) + " ms");

        // === Search by FirstName ===
        String searchFirstName = "John"; // example
        long startName = System.nanoTime();
        var keys = jedis.smembers("firstName:" + searchFirstName.toLowerCase());
        long endName = System.nanoTime();

        if (keys != null && !keys.isEmpty()) {
            System.out.println("Found " + keys.size() + " records with firstName " + searchFirstName + ":");
            for (String k : keys) {
                System.out.println("  → " + jedis.get(k));
            }
        } else {
            System.out.println("No records found for firstName: " + searchFirstName);
        }
        System.out.println("FirstName search took: " + ((endName - startName) / 1_000_000.0) + " ms");

        jedis.close();
    }
}
