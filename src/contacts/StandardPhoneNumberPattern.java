package contacts;

import java.util.regex.Pattern;

public class StandardPhoneNumberPattern implements PhoneNumberPattern {

    @Override
    public Pattern getPattern() {
        final Pattern pattern = Pattern.compile
                ("^([+]?\\d?)?\\s?[-]?([(]?[a-zA-Z0-9]{2,10}\\s?[)]?)?\\s?[-]?([a-zA-Z0-9]{2,3})?\\s?[-]?([a-zA-Z0-9]{2,3})?\\s?[-]?(\\d{2,4}|[a-zA-Z]{2,4})?" +
                        "$|^([+]?\\d?)?\\s?([a-zA-Z0-9]{2,3})?\\s?[-]?[(]?[-]?([a-zA-Z0-9]{2,3})[)]?\\s?[-]?(\\d{2,3}|[a-zA-Z]{2,4})?\\s?[-]?([a-zA-Z0-9]{2,3})?$");

        return pattern;
    }
}
