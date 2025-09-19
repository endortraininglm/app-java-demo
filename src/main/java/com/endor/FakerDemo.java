package com.endor;

import com.github.javafaker.Faker;

/**
 * A simple demonstration of the JavaFaker library.
 * This class is created for an SCA exercise to show the usage of the JavaFaker dependency.
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
     * Main method to demonstrate the usage of JavaFaker.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        FakerDemo demo = new FakerDemo();
        System.out.println("Random Name: " + demo.generateRandomName());
        System.out.println("Random Company: " + demo.generateRandomCompany());
        System.out.println("Random Catchphrase: " + demo.generateRandomCatchphrase());
    }
}