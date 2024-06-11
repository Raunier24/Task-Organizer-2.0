package team.organizer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    private static ArrayList<String> array = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static void create () {
        try {
            FileWriter paper = new FileWriter("ToDoList.txt", true);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public static void callCreate () {
        create();
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

    public static void callAddTask() {
        addTask();
    }

    private static void fillArray() {
        array.clear();
        try {
            FileReader read = new FileReader("ToDoList.txt");
            Scanner arrayAdd = new Scanner(read);
            while (arrayAdd.hasNextLine()) {
                array.add(arrayAdd.nextLine());
            }
        } catch (FileNotFoundException Exception) {
            Exception.printStackTrace();
        }
    }
    private static void Writer() {
        int arrayPosition = 0;
        try {
            PrintWriter writer = new PrintWriter("ToDoList.txt");
            while (array.size() > arrayPosition) {
                writer.println(array.get(arrayPosition));
                arrayPosition++;
            }
            writer.close();
        } catch(Exception error){
            error.printStackTrace();
        }
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
    private static void isEmptyOutput() {
        if (array.isEmpty()) {
            System.out.println("There isn't any task");
        }
        Output();
    }

    public static void callOutput () {
        isEmptyOutput();
    }

    private static void Clear() {
        try {
            PrintWriter writer = new PrintWriter("ToDoList.txt");
            writer.print("");
            writer.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    private static boolean check() {
        if(array.isEmpty()) {
            System.out.println("There isn't any task");
            input = "stop";
            return false;
        } else {
            System.out.println("Write number of line what is done. (If you want to stop write 'stop')");
            return true;
        }
    }
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

    private static void MarkAsDone() {
        do {
            array.clear();
            fillArray();
            Output();
            if(check()) {
                input = scanner.nextLine();
            }
            if(!input.equals("stop")) {
                int userNumber = Integer.parseInt(input);
                String temp = array.get(userNumber - 1);
                if (!temp.startsWith("[X]")) {
                    array.set(userNumber - 1, "[X]" + temp);
                    Clear();
                    System.out.println("Text saved ");
                } else {
                    System.out.println("The task is already marked as Done");
                }
            }
            Writer();
        } while (!input.equals("stop"));
    }

    public static void callMarkAsDone() {
        MarkAsDone();
    }
}
