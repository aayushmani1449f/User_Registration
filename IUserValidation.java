@FunctionalInterface
public interface IUserValidation {
    boolean validate(String input) throws InvalidUserDetailsException;
}
