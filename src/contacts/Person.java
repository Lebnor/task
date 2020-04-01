package contacts;

import java.util.ArrayList;
import java.util.List;

public class Person extends Record {


    private String name;
    private String surName;
    private BirthDate birthDate;
    private Gender gender;

    /**
     * creates a new person with the specified phone number
     *
     * @param phoneNumber the phone number detail associated with the record
     */
    public Person(PhoneNumber phoneNumber, BirthDate birthDate, Gender gender) {
        super(phoneNumber);
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Person() {
        super();
    }

    @Override
    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("sur name");
        fields.add("birth date");
        fields.add("gender");
        fields.add("phone number");
        return fields;
    }

    @Override
    public boolean updateField(String field, String value) {
        switch (field) {
            case "name":
                this.name = value;
                return true;
            case "sur name":
                this.surName = value;
                return true;
            case "gender":
                if (this.gender == null) {
                    this.gender = new Gender();
                }
                return this.gender.setGenderType(value);

            case "birth date":
                if (this.birthDate == null) {
                    this.birthDate = new BirthDate();
                }
                return this.birthDate.update(value);

            case "phone number":
                setPhoneNumber(value);

        }
        return true;
    }

    @Override
    public String getValue(String field) {
        switch (field) {
            case "name":
                return this.name;
            case "sur name":
                return this.surName;
            case "gender":
                if (gender != null)
                return this.gender.toString();
            case "birth date":
                if (birthDate != null)
                return this.birthDate.getBirthDate();
            case "phone number":
                return getPhoneNumber();
            case "time last edit" :

                return getLastChanged().toString();
            case "time created" :

                return getCreationDate().toString();
        }
        return "[not available]";
    }

    @Override
    public void printDetails() {
        for (String field : getFields()) {
            System.out.println(this.fieldName(field) + ": " + getValue(field));
        }
        super.printDetails();
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }

    public void setGender(String gender) {
        switch (gender) {
            case "M":
                this.gender = new Gender(Gender.GenderType.MALE);
                break;
            case "F":
                this.gender = new Gender(Gender.GenderType.FEMALE);
                break;
        }
    }
}
