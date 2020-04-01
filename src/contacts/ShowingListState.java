package contacts;

import java.util.Scanner;

public class ShowingListState implements State {

    private Scanner scanner;
    private ConsoleController controller;

    public ShowingListState(Scanner scanner, ConsoleController controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    @Override
    public void askForInput() {
        System.out.println("[list] Enter action ([number], back)");
        String input = scanner.nextLine();
        if (input.equals("back")) {

        }
        try {
            int selection = Integer.parseInt(input);
            controller.printDetailed(selection);
            controller.setState(new EditingRecordState(scanner, controller, selection));
        } catch (NumberFormatException e) {

        }
    }
}
