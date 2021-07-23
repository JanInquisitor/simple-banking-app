package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        BankAccount user1 = new BankAccount("Fulano", "BA0004");
        user1.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String name, String id) {
        customerName = name;
        customerId = id;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {

        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction");
        }

    }

    void showMenu() {

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is: " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("====================================");
            System.out.println("Please select an option.");
            System.out.println("====================================");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'A' -> {
                    System.out.println("====================================");
                    System.out.println("Your balance: " + balance);
                    System.out.println("====================================");
                    System.out.println("\n");
                }
                case 'B' -> {
                    System.out.println("====================================");
                    System.out.println("Enter amount to deposit");
                    System.out.println("====================================");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                }
                case 'C' -> {
                    System.out.println("====================================");
                    System.out.println("Enter amount to withdraw");
                    System.out.println("====================================");
                    int amount = scanner.nextInt();
                    withdraw(amount);
                    System.out.println("\n");
                }
                case 'D' -> {
                    System.out.println("====================================");
                    getPreviousTransaction();
                    System.out.println("====================================");
                    System.out.println("\n");
                }
                case 'E' -> {
                    break;
                }
                default -> {
                    System.out.println("Invalid option. Please try again.");
                }
            }

        } while (option != 'E');
        System.out.println("Thank you for using our services.");
    }
}