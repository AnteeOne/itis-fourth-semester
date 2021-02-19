package tech.anteeone.springcontrollers.dto;

public class UserDto {
    private String email;
    private String password;
    private String password2;

    public UserDto(String email , String password , String password2) {
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }

    public UserDto(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    @Override
    public String toString() {
        return "FormDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
