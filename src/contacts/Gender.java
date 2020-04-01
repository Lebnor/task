package contacts;

public class Gender {

    public enum GenderType {
        MALE, FEMALE, OTHER, NO_DATA;
    }

    private GenderType genderType;

    public Gender(GenderType genderType) {
        this.genderType = genderType;
    }
    public Gender(String gender) {
        setGenderType(gender);
    }

    public Gender() {
        this.genderType = GenderType.NO_DATA; // default
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public boolean  setGenderType(String gender) {
        switch (gender) {
            case "M" :
                this.genderType = GenderType.MALE;
                return true;
            case "F" :
                this.genderType = GenderType.FEMALE;
            return true;
            case "other" :
                this.genderType = GenderType.OTHER;
                return true;
        }
        return false;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    @Override
    public String toString() {
        if (this.genderType == GenderType.NO_DATA) {
            return "[no data]";
        }
        return genderType.toString().substring(0,1) + genderType.toString().substring(1).toLowerCase();
    }
}
