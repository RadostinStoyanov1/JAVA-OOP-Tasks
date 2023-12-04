package P23DesignPatterns.DemoBuilder;

public class Address {

    private String name;
    private String family;
    private String telephone;
    private String country;
    private String city;

    private Address() {
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private Address address;

        private Builder() {
            this.address = new Address();
        }

        public Builder withName(String name) {
            address.name = name;
            return this;
        }

        public Builder withFamily(String family) {
            address.family = family;
            return this;
        }

        public Builder withTelephone(String telephone) {
            address.telephone = telephone;
            return this;
        }

        public Builder withCountry(String country) {
            address.country = country;
            return this;
        }

        public Builder withCity(String city) {
            address.city = city;
            return this;
        }

        public Address build() {
            return address;
        }
    }
}
