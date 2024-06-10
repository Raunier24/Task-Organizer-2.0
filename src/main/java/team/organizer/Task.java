java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
}
