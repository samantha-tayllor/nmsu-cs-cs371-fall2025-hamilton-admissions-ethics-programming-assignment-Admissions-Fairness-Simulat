// Main.java
// Reads CSV data and prints admissions results.

import java.io.*;
import java.util.*;

public class Main {

    // Parses a CSV line, accounting for quotes and commas
    private static String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"') inQuotes = !inQuotes;
            else if ((c == ',' || c == '\t') && !inQuotes) {
                result.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString().trim());
        return result.toArray(new String[0]);
    }

    // Reads all applicants from a CSV file
    public static List<Applicant> readApplicants(String filename) {
        List<Applicant> applicants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] p = parseCSVLine(line);
                if (p.length < 14) continue;

                try {
                    String name = p[0];
                    int age = Integer.parseInt(p[1]);
                    String geography = p[2];
                    String ethnicity = p[3];
                    double income = Double.parseDouble(p[4].replace("$", "").replace(",", ""));
                    boolean legacy = p[5].equalsIgnoreCase("Yes");
                    boolean local = p[6].equalsIgnoreCase("Yes");
                    double gpa = Double.parseDouble(p[7]);
                    int test = Integer.parseInt(p[8]);
                    double extra = Double.parseDouble(p[9]);
                    double essay = Double.parseDouble(p[10]);
                    double rec = Double.parseDouble(p[11]);
                    boolean firstGen = p[12].equalsIgnoreCase("Yes");
                    boolean disability = p[13].equalsIgnoreCase("Yes");

                    applicants.add(new Applicant(name, age, geography, ethnicity, income,
                            legacy, local, gpa, test, extra, essay, rec, firstGen, disability));

                } catch (Exception e) {
                    System.out.println("Skipping malformed row: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return applicants;
    }

    public static void main(String[] args) {
        List<Applicant> applicants = readApplicants("applicants.csv");
        if (applicants.isEmpty()) {
            System.out.println("No applicants found. Check CSV format or path.");
            return;
        }

        double cutoff = 0.82; // stricter cutoff → some admitted, some rejected

        System.out.println("=== Admissions Results ===");
        for (Applicant app : applicants) {
            double blind = Admissions.blindScore(app);
            double aware = Admissions.awareScore(app);

            String blindDecision = (blind >= cutoff) ? "Admitted" : "Rejected";
            String awareDecision = (aware >= cutoff) ? "Admitted" : "Rejected";

            System.out.printf("%-15s | Blind: %.2f (%s) | Aware: %.2f (%s)%n",
                    app.name, blind, blindDecision, aware, awareDecision);
        }
    }
}