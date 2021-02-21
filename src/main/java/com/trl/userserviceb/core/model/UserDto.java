package com.trl.userserviceb.core.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * This class is designed to represent Dto of user.
 *
 * @author Tsyupryk Roman
 */
@Schema(name = "User", description = "Dto that represent a user.")
public class UserDto extends BaseDto {

    @Schema(required = true, example = "Tom", description = "First name of user.", implementation = String.class)
    @NotBlank
    private String firstName;

    @Schema(required = true, example = "King", description = "Last name of user.", implementation = String.class)
    @NotBlank
    private String lastName;

    @Schema(required = true, example = "tom", description = "Username of user.", implementation = String.class)
    @NotBlank
    private String username;

    @Schema(required = true, example = "tom@email.com", description = "Email of user.", implementation = String.class)
    @NotBlank
    private String email;

    @Schema(required = true, example = "secret_password",
            description = "Password of account.", implementation = String.class)
    @NotBlank
    private String password;

    @Schema(example = "2000-01-01", description = "Birthday of user.", implementation = LocalDate.class)
    private LocalDate birthday;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof UserDto)) {
            return false;
        }

        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id)
                && Objects.equals(createdDate, userDto.createdDate)
                && Objects.equals(updatedDate, userDto.updatedDate)
                && Objects.equals(firstName, userDto.firstName)
                && Objects.equals(lastName, userDto.lastName)
                && Objects.equals(username, userDto.username)
                && Objects.equals(email, userDto.email)
                && Objects.equals(password, userDto.password)
                && Objects.equals(birthday, userDto.birthday);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, updatedDate, firstName, lastName, username,
                email, password, birthday);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("createdDate=" + createdDate)
                .add("updatedDate=" + updatedDate)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("username='" + username + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("birthday=" + birthday)
                .toString();
    }

    public static final class Builder {

        private Long id;

        private LocalDateTime createdDate;

        private LocalDateTime updatedDate;

        private String firstName;

        private String lastName;

        private String username;

        private String email;

        private String password;

        private LocalDate birthday;

        public Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder withUpdatedDate(LocalDateTime updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserDto build() {
            UserDto result = new UserDto();

            result.setId(this.id);
            result.setCreatedDate(this.createdDate);
            result.setUpdatedDate(this.updatedDate);
            result.setFirstName(this.firstName);
            result.setLastName(this.lastName);
            result.setUsername(this.username);
            result.setEmail(this.email);
            result.setPassword(this.password);
            result.setBirthday(this.birthday);

            return result;
        }

    }

}

