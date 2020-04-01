package contacts;

public class PhoneNumber  {


    public static  PhoneNumber createDefault(String number) {
        return new PhoneNumber(number);
    }

    public PhoneNumber() {
        this.validator = new StandardPhoneNumberValidator(new StandardPhoneNumberPattern());
        this.number = "[no data]"; // default value
    }

    private PhoneNumberValidator validator;
    private String number;

    public PhoneNumber(String number, PhoneNumberValidator validator) {
        this.validator = validator;
        this.number = number;
    }

    public PhoneNumber(String number) {
        this.validator = new StandardPhoneNumberValidator(new StandardPhoneNumberPattern());
        this.number = number;
    }


    /** sets the phone number as the number given
     * @param newNumber the new number that this object contains
     * @return true if the number is valid and false otherwise
     */
    public boolean updateNumber(String newNumber) {
        if (validator.isValidPhoneNumber(newNumber)) {
            this.number = newNumber;
            return true;
        }
        else {
            this.number = "[no number]";
            return false;
        }
    }

    public String getPhoneNumber() {
        return number;
    }
}
