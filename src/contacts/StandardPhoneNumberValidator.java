package contacts;

import java.util.regex.Matcher;

public class StandardPhoneNumberValidator implements PhoneNumberValidator {

    private PhoneNumberPattern pattern;

    public StandardPhoneNumberValidator(PhoneNumberPattern pattern) {
        this.pattern = pattern;
    }


    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        Matcher matcher = pattern.getPattern().matcher(phoneNumber);
        return matcher.matches();
    }
}
