package Main;

import Common.Connect;
import Controller.AppController;
import Controller.CandidateController;
import Model.Candidate;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppController appController = new AppController();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            appController.showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CandidateController candidateController = new CandidateController();
                    candidateController.addCandidate();
                    break;
                default:
                    System.out.println("...");
                    break;
            }
        } while (choice != 6);

    }
}
