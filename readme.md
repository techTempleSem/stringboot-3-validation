# validation

- @NotNull : != null 
- @NotBlank : != null, !=""
- @NotEmpty : != null, !="", !=" "
- @Size(min = 8) : 문자열 길이 최소값
- @Min(1), @Max(100): 숫자 최솟값, 최댓값
- @Email : 이메일
- @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "wrong regexp") : 정규식
- @FutureOrPresent : 현재 시간이나 미래 시간

- @Valid : 컨트롤러 입력 받을 때 붙여주면 입력받으면서 검증도 해줌


BindingResult : @valid가 실행되었을 때 결과를 변수에 넣는다

- @AssertTrue: true일때만 실행. 이때, 함수 명은 is로 시작

@AssertTrue
public boolean isNameCheck(){
    return false;
}

## use annotation
- @Constraint(validatedBy = PhoneNumberValidator.class): 어떤 클래스에서 검증할 것이냐
- @Target({ElementType.FIELD}): 변수에 적용시킬 것
- @Retention(RetentionPolicy.RUNTIME): 런타임에 적용시킬 것

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {