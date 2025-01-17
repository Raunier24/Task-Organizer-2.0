package team.organizer;

import java.util.Scanner;

public final class App {
    private App() {
    }
    public static void main(String[] args) {
        Task.callCreate();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("Welcome to the ToDo List\n=========================");
        do {
            System.out.println("Select: (1.Add task) (2.Delete task) (3.List of tasks) (4.Mark as Done) (5.Exit)");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println("You opened create");
                    Task.callAddTask();
                    break;
                case "2":
                    System.out.println("You opened delete");
                    Task.callDelete();
                    break;
                case "3":
                    System.out.println("You opened List");
                    Task.callOutput();
                    break;
                case "4":
                    System.out.println("You opened Mark as Done");
                    Task.callMarkAsDone();
                    break;
                case "5":
                    System.out.println("You closed the program");
                    break;
                default:
                    System.out.println("You wrote something wrong");
                    break;
            }

        } while (!userInput.equals("5"));
    }
}
