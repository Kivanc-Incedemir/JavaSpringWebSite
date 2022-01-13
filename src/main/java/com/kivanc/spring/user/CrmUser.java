package com.kivanc.spring.user;

import com.kivanc.spring.validation.FieldMatch;
import com.kivanc.spring.validation.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
@Getter
@Setter
public class CrmUser {

@NotNull(message = "is required")
@Size(min = 1, message = "is required")
private String userName;

@NotNull(message = "is required")
@Size(min = 1, message = "is required")
private String password;

@NotNull(message = "is required")
@Size(min = 1, message = "is required")
private String matchingPassword;

@NotNull(message = "is required")
@Size(min = 1, message = "is required")
private String firstName;

@NotNull(message = "is required")
@Size(min = 1, message = "is required")
private String lastName;

@ValidEmail
@NotNull(message = "is required")
@Size(min = 1, message = "is required")
private String email;

public CrmUser() {

}


}
