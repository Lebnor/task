package contacts;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {


    private PhoneBook contacts;
    private Scanner scanner;
    private State state;

    public ConsoleController(PhoneBook contacts, Scanner scanner) {
        this.contacts = contacts;
        this.scanner = scanner;
    }

    public void handleRemove(int selection) {
        // todo can add confirmation message here
        contacts.removeOneBased(selection);
    }


    public void handleList() {
        contacts.showList();
        this.state = new ShowingListState(scanner, this);

    }

    public void handleEdit() {
        if (contacts.getSize() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        contacts.showList();
        System.out.println("Select a record:");
        int recordIndex = Integer.parseInt(scanner.nextLine());
        if (!contacts.validRecord(recordIndex)) {
            System.out.println("Invalid record");
        } else {
            Record theRecord = contacts.getOneBased(recordIndex);
            handleEdit(theRecord);

        }
        System.out.println("The record updated!");
    }

    public void handleEdit(int selection) {
        if (selection < 1 || selection > contacts.getSize()) {
            return;
        }
        Record record = contacts.getOneBased(selection);
        handleEdit(record);
    }

    private void handleEdit(Record record) {
        List<String> fields = record.getFields();
        System.out.print("Select field (");
        System.out.print(fields.get(0));
        for (int i = 1; i < fields.size(); i++) {
            System.out.print(", " + fields.get(i));
        }
        System.out.print(")\n");
        String fieldToEdit = scanner.nextLine();
        if (fields.contains(fieldToEdit)) {
            System.out.println("Enter " + fieldToEdit + ":");
            String value = scanner.nextLine();
            record.updateField(fieldToEdit, value);
        }

    }


    private void handleEditAddress(Organization theRecord) {
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        theRecord.setOrganizationAddress(address);
    }

    public void handleCount() {
        int records = contacts.getSize();
        System.out.printf("The Phone Book has %d records.\n", records);
    }

    public void handleAdd() {
        System.out.println("Enter the type (person, organization):");
        String selection = scanner.nextLine();
        Record record;
        if (selection.equals("person")) {
            record = new Person();
        } else if (selection.equals("organization")) {
            record = new Organization();
        } else {
            return;
        }

        List<String> fields = record.getFields();
        for (String field : fields) {
            System.out.println("Enter " + field + ":");
            String fieldValue = scanner.nextLine();
            if (!record.updateField(field, fieldValue)) {
                System.out.println("Bad value for " + field);
            }
        }
        contacts.addContact(record);
        System.out.println("The record added.");

    }

    public void handleSearch() {
        System.out.println("Enter search query:");
        String search = scanner.nextLine();
        List<Record> results = contacts.query(search);
        System.out.println("Found " + results.size() + " results:");
        if (results.size() == 0) {
            this.state = new MainMenuState(scanner, this);
            return;
        }
        for (int i = 0; i < results.size(); i++) {
            Record record = results.get(i);
            System.out.println((i + 1) + " " + record);
        }
        this.state = new SearchState(scanner, this);
    }

    public State getCurrentState() {
        if (this.state == null) {
            return new MainMenuState(scanner, this);
        }
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void printDetailed(int selection) {
        Record record = contacts.getOneBased(selection);
        record.printDetails();
    }


}
