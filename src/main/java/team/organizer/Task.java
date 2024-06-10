package team.organizer;

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
}
