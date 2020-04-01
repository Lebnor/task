package contacts;

import java.util.Scanner;

public class Main {



    private static PhoneBook contacts = new PhoneBook();
    private static ConsoleController consoleController;



    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        consoleController = new ConsoleController(contacts, scanner);

        while (true) {
            State state = consoleController.getCurrentState();
            state.askForInput();
            System.out.println();
        }
    }
//    }
}
