package contacts;

import java.time.LocalDateTime;

public class BirthDate {

    private String birthDate;

    public BirthDate(String birthDate) {
        update(birthDate);
    }

    public BirthDate() {
        this.birthDate = "[no data]"; // default value
    }

    public String getBirthDate() {
        return birthDate;
    }

    public boolean update(String date) {
        if (isValidDate(date)) {
            this.birthDate = date;
            return true;
        }
        return false;
    }


    private boolean isValidDate(String date) {
        return date.matches("([0-2][1-9]|3[0-1])/(0[1-9]|1[0-2])/(19\\d{2}|2\\d{3})");

    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "birthDate='" + birthDate + '\'' +
                '}';
    }
}
