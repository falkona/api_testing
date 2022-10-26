package ddnTesting.models;

import lombok.Data;

import java.util.Objects;

@Data
public class User {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userStatus == user.userStatus
                && username.equals(user.username)
                && firstName.equals(user.firstName)
                && lastName.equals(user.lastName)
                && email.equals(user.email)
                && phone.equals(user.phone)
                && id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, email, password, phone, userStatus, id);
    }

}
