package org.northcoders.demo;

import InputAndParser.AdminRemote;
import Rover.Rover;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminRemote manager = new AdminRemote(scanner);
        manager.createRover(scanner);
        manager.storeTheInstruction(scanner);
        manager.startAllRovers();
        scanner.close();
    }
}