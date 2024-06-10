package team.organizer;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Task {
   
    private static void Delete() {
        do {
            array.clear();
            fillArray();
            Output();
            if (check()) {
                input = scanner.nextLine();
            }
            if (input.equals("stop")) {
                break;
            }
            Clear();
            int inputInt = Integer.parseInt(input);
            int inputPosition = inputInt - 1;
            array.remove(inputPosition);
            Writer();
        } while (!input.equals("stop"));
    }

    public static void callDelete() {
        Delete();
    }

    private static void addTask() {
        do {
            System.out.println("Enter text to save: (if you want to stop write 'stop')");
            input = scanner.nextLine();
            if (!input.equals("stop")) {
                try {
                    FileWriter paper = new FileWriter("ToDoList.txt", true);
                    PrintWriter note = new PrintWriter(paper);
                    note.println(input);
                    System.out.println("Text saved " + input);
                    note.close();
                } catch (Exception error) {
                    error.printStackTrace();
                }
            }
        } while (!input.equals("stop"));
    }
}

