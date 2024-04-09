import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Initialize
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        final String menu = "[A] - Add, [D] - Delete, [P] - Print, [Q] - Quit"; // Menu for the user

        boolean done = false;

        String cmd = "";

        do {
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]"); // Acceptable inputs
            switch (cmd) {
                case "A": addItem(); break;
                case "D": deleteItem(); break;
                case "P": displayList(); break;
                case "Q": done = quitList(); break;
            }
        } while (!done);

    }

    // [A]
    private static void addItem() {
        list.add(SafeInput.getNonZeroLenString(in, "What item to add to the list? [String]"));
    }

    // [D]
    private static void deleteItem() {
        list.remove((SafeInput.getRangedInt(in, "What item number to delete?", 1, list.size())) - 1);
    }

    // [P]
    private static void displayList() {
        if(!list.isEmpty()) {
            System.out.println();
            list.forEach(System.out::println);
            for (int x=0;x<list.size();x++) {
                System.out.printf("%3d", x+1, list.get(x));
                System.out.println(); // Filler
            }
        } else {
            System.out.println("The list is currently empty. Add items with [A] to fill out the list.");
        }
    }

    // [Q]
    private static boolean quitList() {
        return SafeInput.getYNConfirm(in, "Confirm quit [Y/N]");
    }
}