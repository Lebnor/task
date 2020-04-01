package contacts;

import java.time.LocalDateTime;
import java.util.List;


public abstract class Record {

    private PhoneNumber phoneNumber;
    private Date date;

    /**
     * creates a new record with the specified phone number validation method
     *
     * @param phoneNumber the phone number detail associated with the record
     */
    public Record(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.date = new Date();
    }

    public Record() {
        this.phoneNumber = new PhoneNumber();
        this.date = new Date();
    }

    // todo better implementation of translating a field name for printing
    public  String fieldName(String word) {
        switch (word) {
            case "name" :
                if (this instanceof Person) {
                    return "Name";
                } else {
                    return "Organization name";
                }
            case "sur name" :
                return "Surname";
            case "birth date" :
                return "Birth date";
            case "gender" :
                return "contacts.Gender";
            case "phone number" :
                return "Number";
            case "address" :
                return "Address";

        }
        return null;
    }


    public abstract List<String> getFields();
    public abstract boolean updateField(String field, String value);
    public abstract String getValue(String field);


    public boolean setPhoneNumber(String newNumber) {
        if (this.phoneNumber == null) {
            this.phoneNumber = new PhoneNumber();
        }

        if (this.phoneNumber.updateNumber(newNumber)) {
            update();
            return true;
        }
        return false;
    }

    public void setPhoneNumber(PhoneNumber newNumber) {
        this.phoneNumber = newNumber;
    }

    public LocalDateTime getCreationDate() {
        return date.getCreationDate();
    }

    public LocalDateTime getLastChanged() {
        return date.getLastEdited();
    }


    public void update() {
        date.edited();
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }


    public  void printDetails() {
//        System.out.println("phone number: " + getPhoneNumber());
        System.out.println("Time created: " + getCreationDate());
        System.out.println("Time last edit: " + getLastChanged());
    }
}
