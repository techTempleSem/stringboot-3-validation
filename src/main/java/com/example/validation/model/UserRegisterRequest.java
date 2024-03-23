package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class UserRegisterRequest {

//    @NotBlank
    private String name;

//    @NotBlank
    private String nickname;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth(pattern = "yyyy-MM")
    private String birthdatYearMonth;

    @AssertTrue(message = "name or nickname")
    public boolean isNameCheck(){
        if(Objects.nonNull(name) &&  !name.isBlank()){
            return true;
        }
        if(Objects.nonNull(nickname) &&  !nickname.isBlank()){
            return true;
        }
        return false;
    }
}
