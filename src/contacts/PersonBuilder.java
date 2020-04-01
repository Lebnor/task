package contacts;


public class PersonBuilder {

    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public void name(String name) {
        this.person.updateField("name", name);
    }

    public void surName(String surName) {
        this.person.updateField("sur name", surName);
    }

    public boolean phoneNumber(String number) {
        PhoneNumber phoneNumber = new PhoneNumber();
        if (phoneNumber.updateNumber(number)) {
            person.setPhoneNumber(phoneNumber);
            return true;
        }
        return false;
    }

    public boolean gender(String gender) {
        Gender theGender = new Gender();
        switch (gender) {
            case "M":
                theGender.setGenderType(Gender.GenderType.MALE);
                person.updateField("gender", "M");
                return true;
            case "F":
                theGender.setGenderType(Gender.GenderType.FEMALE);
                person.updateField("gender", "F");
                return true;
        }
        // no valid input has been given
        return false;
    }

    public boolean birthDate(String date) {
        BirthDate birthDate = new BirthDate();
        if (birthDate.update(date)) {
            person.updateField("birth date", date);
            return true;
        }
        return false;
    }

    public Person get() {
        return this.person;
    }
}
