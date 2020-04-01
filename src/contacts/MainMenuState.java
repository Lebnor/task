package contacts;

import java.util.Scanner;

public class MainMenuState implements State {

    private Scanner scanner;
    private ConsoleController controller;

    public MainMenuState(Scanner scanner, ConsoleController controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    @Override
    public void askForInput() {
        System.out.println("[menu] Enter action (add, list, search, count, exit):");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("exit")) {
            System.exit(0);
        }
        switch (input) {
            case "add":
                handleAdd();
                break;
            case "search" :
                handleSearch();
                break;
            case "edit":
                handleEdit();
                break;
            case "count":
                handleCount();
                break;
            case "list":
                handleList();
                break;
            case "exit":
                return;


        }
    }
    private  void handleSearch() {
        controller.handleSearch();
    }

    public  void handleList() {
        controller.handleList();
    }

    public  void handleEdit() {
        controller.handleEdit();
    }

    public  void handleCount() {
        controller.handleCount();
    }

    public  void handleAdd() {
        controller.handleAdd();
    }
}