package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Organization extends Record {

    private String organizationName;
    private String organizationAddress;

    /**
     * creates a new record with the specified phone number validation method
     *
     * @param phoneNumber the phone number detail associated with the record
     */
    public Organization(PhoneNumber phoneNumber) {
        super(phoneNumber);
    }

    public Organization() {
        super();
    }

    @Override
    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("address");
        fields.add("phone number");
//        fields.add("time created");
//        fields.add("time last edit");
        return fields;
    }

    @Override
    public void printDetails() {
        for (String field : getFields()) {
            System.out.println(this.fieldName(field) + ": " + getValue(field));
        }
        super.printDetails();
    }

    @Override
    public boolean updateField(String field, String value) {
        switch (field) {
            case "name":
                this.organizationName = value;
                return true;
            case "address":
                this.organizationAddress = value;
                return true;
            case "phone number":
                return setPhoneNumber(value);

        }
        return true;
    }

    @Override
    public String getValue(String field) {
        switch (field) {
            case "name":
                return this.organizationName;
            case "address":
                return this.organizationAddress;
            case "phone number":
                return getPhoneNumber();
            case "time last edit":
                return getLastChanged().toString();
            case "time created":
                return getCreationDate().toString();
        }
        return "[not available]";
    }

    @Override
    public String toString() {
        return organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }
}
