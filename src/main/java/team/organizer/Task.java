java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Task {
    private static ArrayList<String> array = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
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
    private static void Output() {
        fillArray();
        int arrayPosition = 0;
        while (arrayPosition < array.size()) {
            String starts = array.get(arrayPosition);
            if (starts.startsWith("[X]")) {
                System.out.println(arrayPosition + 1 + ")" + array.get(arrayPosition));
            } else {
                System.out.println(arrayPosition + 1 + ")" + "[ ]" + array.get(arrayPosition));
            }
            arrayPosition++;
        }
    }
}

