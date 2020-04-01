package contacts;

import java.util.Scanner;

public class SearchState implements State {

    private Scanner scanner;
    private ConsoleController controller;

    public SearchState(Scanner scanner, ConsoleController controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    @Override
    public void askForInput() {
        while (true) {
            System.out.println("[search] Enter action ([number], back, again):");
            String input = scanner.nextLine();

            switch (input) {
                case "again" :
                    controller.handleSearch();
                    break;
                case "back" :
                    controller.setState(new MainMenuState(scanner, controller));
                    return;

            }
            try {
                int selection = Integer.parseInt(input);
                controller.printDetailed(selection);
                controller.setState(new EditingRecordState(scanner, controller, selection));
                break;
            } catch (NumberFormatException e) {
                // do something
            }

        }
    }
}