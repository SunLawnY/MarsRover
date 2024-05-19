package org.northcoders.demo;

import InputAndParser.AdminRemote;
import Rover.MoveFunction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminRemote manger = new AdminRemote(scanner);
        manger.createRover(scanner);
        manger.performMove(MoveFunction.M);
        manger.getRoverFacing();


        System.out.println("End of Program");
        scanner.close();
    }
}