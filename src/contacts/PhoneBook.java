package contacts;

import java.util.ArrayList;
import java.util.List;


public class PhoneBook {
    private List<Record> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    public int getSize() {
        return contacts.size();
    }

    public void addContact(Record person) {
        contacts.add(person);
    }


    public boolean validRecord(int record) {
        return record > 0 && record <= contacts.size();
    }



    /**
     * get contact one-based
     *
     * @param record the location of the person in the list. the list starts from 1
     * @return the person in that place
     */
    public Record getOneBased(int record) {
        if (validRecord(record)) {
            return contacts.get(record - 1);
        }
        return null;
    }

    public void showList() {
        for (int i = 0; i < contacts.size(); i++) {
            Record record = contacts.get(i);
            System.out.println((i + 1) + ". " + record);

        }
    }

    public void removeOneBased(int record) {
        if (validRecord(record))
        contacts.remove(--record);
    }

    public List<Record> query(String search) {
        List<Record> results = new ArrayList<>();
        for (Record record : contacts) {

            for (String field : record.getFields()) {
                if (record.getValue(field) != null && record.getValue(field).toLowerCase().contains(search.toLowerCase())) {
                    results.add(record);
                    break;
                }
            }
        }
        return results;
    }

}