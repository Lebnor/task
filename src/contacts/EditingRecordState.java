package contacts;

import java.util.Scanner;

public class EditingRecordState implements State {


    private Scanner scanner;
    private ConsoleController controller;
    private int selection;

    public EditingRecordState(Scanner scanner, ConsoleController controller, int selection) {
        this.scanner = scanner;
        this.controller = controller;
        this.selection = selection;
    }

    @Override
    public void askForInput() {
        while (true) {
            System.out.println("[record] Enter action (edit, delete, menu):");
            String input = scanner.nextLine();

            switch (input) {
                case "edit" :
                    controller.handleEdit(selection);
                    break;
                case "delete" :
                    controller.handleRemove(selection);
                    controller.setState(new MainMenuState(scanner, controller));
                    return;
                case "menu" :
                    controller.setState(new MainMenuState(scanner, controller));
                    return;
            }
        }
    }
}