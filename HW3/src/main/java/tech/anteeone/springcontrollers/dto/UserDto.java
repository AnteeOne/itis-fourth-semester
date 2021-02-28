package tech.anteeone.springcontrollers.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDto {
    @Size(min = 8,max = 64)
    public String email;
    @Min(8)
    @NotNull
    public  String password;
    @Min(8)
    @NotNull
    public  String password2;

    public UserDto(String email , String password , String password2) {
        this.email = email;
        this.password = password;
        this.password2 = password2;
    }

    public UserDto() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "FormDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(email , userDto.email) &&
                Objects.equals(password , userDto.password) &&
                Objects.equals(password2 , userDto.password2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email , password , password2);
    }
}
