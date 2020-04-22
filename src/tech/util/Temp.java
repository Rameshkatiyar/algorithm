package tech.util;

import java.util.List;

public class Temp {
    public static void main(String[] args) {
        List<String> performanceList = FileReader.read("/Users/rameshkatiyar/IdeaProjects/algorithm/testFiles/", "Lead - QA - Mid Year Performance Check-In - Temp.tsv");

        performanceList.stream()
                .forEach(
                        row ->{
                            String[] column = row.split("\t");
                            System.out.println("Name: "+column[0]+"\n");
                            System.out.println("Expected Roles: "+column[1].replace("\n", ", "));
                            System.out.println("Answer: "+column[3]);
                            System.out.println("Details:");
                            System.out.println(column[2]);

                            System.out.println("\n\n");

                            System.out.println("Answer: "+column[8]);
                            System.out.println("Details:");
                            System.out.println("Domain/Product Knowledge: "+column[4]);
                            System.out.println("Automation: "+column[5]);
                            System.out.println("Test: "+column[6]);
                            System.out.println("Communication/Collaboration/Ownership: "+column[7]);

                            System.out.println("\n\n");

                            System.out.println("Improvement Area 1: " + column[9]);
                            System.out.println("Improvement Area 2: " + column[10]);


                            System.out.println("\n\n"+"___________________________________"+"\n\n");
                        }
                );

    }
}
