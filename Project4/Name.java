package utils;

public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void changeFirstName(String newName) {
        firstName = newName;
    }

    public void changeLastName(String newName) {
        lastName = newName;
    }

    private boolean sameFirstName(String str) {
        return firstName.compareTo(str) == 0;
    }

    private boolean sameLastName(String str) {
        return lastName.compareTo(str) == 0;
    }

    public String toString() {
        return firstName + "," + lastName;
    }
}
