import java.util.regex.Pattern;

public class UserRegistration {
    public boolean validateFirstName(String firstName) throws InvalidUserDetailsException {
        if (!Pattern.matches("^[A-Z][a-zA-Z]{2,}$", firstName)) {
            throw new InvalidUserDetailsException("Invalid First Name");
        }
        return true;
    }

    public boolean validateLastName(String lastName) throws InvalidUserDetailsException {
        if (!Pattern.matches("^[A-Z][a-zA-Z]{2,}$", lastName)) {
            throw new InvalidUserDetailsException("Invalid Last Name");
        }
        return true;
    }

    public boolean validateEmail(String email) throws InvalidUserDetailsException {
        if (!Pattern.matches("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$", email)) {
            throw new InvalidUserDetailsException("Invalid Email");
        }
        return true;
    }

    public boolean validateMobile(String mobile) throws InvalidUserDetailsException {
        if (!Pattern.matches("^[0-9]{2}\\s[0-9]{10}$", mobile)) {
            throw new InvalidUserDetailsException("Invalid Mobile Number");
        }
        return true;
    }

    public boolean validatePasswordRule1(String password) throws InvalidUserDetailsException {
        if (!Pattern.matches("^.{8,}$", password)) {
            throw new InvalidUserDetailsException("Invalid Password");
        }
        return true;
    }

    public boolean validatePasswordRule2(String password) throws InvalidUserDetailsException {
        if (!Pattern.matches("^(?=.*[A-Z]).{8,}$", password)) {
            throw new InvalidUserDetailsException("Invalid Password");
        }
        return true;
    }

    public boolean validatePasswordRule3(String password) throws InvalidUserDetailsException {
        if (!Pattern.matches("^(?=.*[A-Z])(?=.*[0-9]).{8,}$", password)) {
            throw new InvalidUserDetailsException("Invalid Password");
        }
        return true;
    }

    public boolean validatePasswordRule4(String password) throws InvalidUserDetailsException {
        if (!Pattern.matches("^(?=.*[A-Z])(?=.*[0-9])(?=[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$).{8,}$", password)) {
            throw new InvalidUserDetailsException("Invalid Password");
        }
        return true;
    }
}
