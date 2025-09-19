package com.endor;

import com.github.javafaker.Faker;
import org.yaml.snakeyaml.Yaml;
import java.io.StringReader;

/**
 * A simple demonstration of the JavaFaker library.
 * This class is created for an SCA exercise to show the usage of the JavaFaker dependency.
 * It also demonstrates the SnakeYAML vulnerability (GHSA-rvwf-54qp-4r6v) and its fix.
 */
public class FakerDemo {

    private Faker faker;

    public FakerDemo() {
        this.faker = new Faker();
    }

    /**
     * Generates a random name using JavaFaker.
     * @return a random name
     */
    public String generateRandomName() {
        return faker.name().fullName();
    }

    /**
     * Generates a random company name using JavaFaker.
     * @return a random company name
     */
    public String generateRandomCompany() {
        return faker.company().name();
    }

    /**
     * Generates a random catchphrase using JavaFaker.
     * @return a random catchphrase
     */
    public String generateRandomCatchphrase() {
        return faker.company().catchPhrase();
    }

    /**
     * Demonstrates the SnakeYAML vulnerability (GHSA-rvwf-54qp-4r6v) related to entity expansion.
     * This vulnerability is fixed in SnakeYAML 1.26+.
     * 
     * @param yamlInput the YAML input string that might contain entity expansions
     * @return the parsed YAML object
     */
    public Object demonstrateSnakeYamlVulnerability(String yamlInput) {
        // In vulnerable versions of SnakeYAML (before 1.26), 
        // this could lead to entity expansion attacks
        Yaml yaml = new Yaml();
        return yaml.load(yamlInput);
    }

    /**
     * Main method to demonstrate the usage of JavaFaker and SnakeYAML.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        FakerDemo demo = new FakerDemo();
        System.out.println("Random Name: " + demo.generateRandomName());
        System.out.println("Random Company: " + demo.generateRandomCompany());
        System.out.println("Random Catchphrase: " + demo.generateRandomCatchphrase());

        // Example of a YAML input that could be problematic in vulnerable versions
        // This is a simplified example - actual exploits would be more complex
        String yamlInput = "key: value";
        try {
            Object result = demo.demonstrateSnakeYamlVulnerability(yamlInput);
            System.out.println("YAML parsing result: " + result);
        } catch (Exception e) {
            System.out.println("Error parsing YAML: " + e.getMessage());
        }
    }
}
