package contacts;

public class OrganizationBuilder {
    private Organization organization;

    public OrganizationBuilder() {
        this.organization = new Organization();
    }

    public void addName(String name) {
        this.organization.setOrganizationName(name);
    }

    public void addAddress(String address) {
        this.organization.setOrganizationAddress(address);
    }

    public void addNumber(String number) {
        this.organization.setPhoneNumber(new PhoneNumber(number));
    }

    public Organization get() {
        return this.organization;
    }
}
