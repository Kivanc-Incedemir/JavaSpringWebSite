package com.kivanc.spring.user.VM;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CrmUserVM {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String userName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

}
