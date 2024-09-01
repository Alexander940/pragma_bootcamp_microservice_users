package com.pragma.emazon.domain.usecase;

import com.pragma.emazon.domain.exceptions.InvalidEmailException;
import com.pragma.emazon.domain.exceptions.InvalidPhoneNumberException;
import com.pragma.emazon.domain.exceptions.NumericException;
import com.pragma.emazon.domain.exceptions.UnderAgeException;
import com.pragma.emazon.domain.model.User;
import com.pragma.emazon.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserUseCaseTest {

    private UserUseCase userUseCase;
    @Mock
    private IUserPersistencePort userPersistencePort;

    @BeforeEach
    void setUp() {
        try (AutoCloseable mocks = MockitoAnnotations.openMocks(this)) {
            userUseCase = new UserUseCase(userPersistencePort);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void when_saveUser_method_is_called_and_returns_a_User() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2002, Calendar.APRIL, 7);
        User user = new User.Builder()
                .name("username")
                .password("password")
                .email("admin@gmail.com")
                .roleName("ADMIN")
                .phone("+12345678901")
                .documentID("102012301320")
                .birthday(calendar)
                .locked(0)
                .disabled(1)
                .build();

        when(userPersistencePort.saveUser(user)).thenReturn(user);

        User userResponse = userUseCase.saveuser(user);

        assertEquals(user, userResponse);
    }

    @Test
    void when_saveUser_method_is_called_and_the_email_doesnt_have_at_sign_simbol_and_returns_an_InvalidEmailException() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2002, Calendar.APRIL, 7);
        User user = new User.Builder()
                .name("username")
                .password("password")
                .email("admingmail.com")
                .roleName("ADMIN")
                .phone("+12345678901")
                .documentID("102012301320")
                .birthday(calendar)
                .locked(0)
                .disabled(1)
                .build();

        assertThrows(InvalidEmailException.class, () -> userUseCase.saveuser(user));
    }

    @Test
    void when_saveUser_method_is_called_and_the_email_doesnt_have_point_and_returns_an_InvalidEmailException() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2002, Calendar.APRIL, 7);
        User user = new User.Builder()
                .name("username")
                .password("password")
                .email("admin@gmailcom")
                .roleName("ADMIN")
                .phone("+12345678901")
                .documentID("102012301320")
                .birthday(calendar)
                .locked(0)
                .disabled(1)
                .build();

        assertThrows(InvalidEmailException.class, () -> userUseCase.saveuser(user));
    }

    @Test
    void when_saveUser_method_is_called_and_the_phone_number_contains_characters_different_from_number_and_throws_a_InvalidPhoneNumberException() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2002, Calendar.APRIL, 7);
        User user = new User.Builder()
                .name("username")
                .password("password")
                .email("admin@gmail.com")
                .roleName("ADMIN")
                .phone("+12a45678901")
                .documentID("102012301320")
                .birthday(calendar)
                .locked(0)
                .disabled(1)
                .build();

        assertThrows(InvalidPhoneNumberException.class, () -> userUseCase.saveuser(user));
    }

    @Test
    void when_saveUser_method_is_called_and_documentID_have_charecters_different_from_numbers_and_throws_a_NumericException() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2002, Calendar.APRIL, 7);
        User user = new User.Builder()
                .name("username")
                .password("password")
                .email("admin@gmail.com")
                .roleName("ADMIN")
                .phone("+12345678901")
                .documentID("1020a2301320")
                .birthday(calendar)
                .locked(0)
                .disabled(1)
                .build();

        assertThrows(NumericException.class, () -> userUseCase.saveuser(user));
    }

    @Test
    void when_saveUser_method_is_called_and_the_user_is_under_eighteen_years_old_and_throws_a_UnderAgeException() {
        User user = new User.Builder()
                .name("username")
                .password("password")
                .email("admin@gmail.com")
                .roleName("ADMIN")
                .phone("+12345678901")
                .documentID("102012301320")
                .birthday(Calendar.getInstance())
                .locked(0)
                .disabled(1)
                .build();

        assertThrows(UnderAgeException.class, () -> userUseCase.saveuser(user));
    }
}