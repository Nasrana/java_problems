class Defang {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}