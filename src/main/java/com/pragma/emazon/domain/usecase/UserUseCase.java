package com.pragma.emazon.domain.usecase;

import com.pragma.emazon.domain.api.IUserServicePort;
import com.pragma.emazon.domain.exceptions.InvalidEmailException;
import com.pragma.emazon.domain.exceptions.InvalidPhoneNumberException;
import com.pragma.emazon.domain.exceptions.NumericException;
import com.pragma.emazon.domain.exceptions.UnderAgeException;
import com.pragma.emazon.domain.model.User;
import com.pragma.emazon.domain.spi.IUserPersistencePort;
import com.pragma.emazon.domain.util.CalendarUtil;
import com.pragma.emazon.domain.util.StringMatcherUtil;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User saveuser(User user) {
        // This exception is thrown when the email is invalid
        if(!StringMatcherUtil.isValidEmail(user.getEmail())) {
            throw new InvalidEmailException("Invalid email");
        }

        // This exception is thrown when the phone number contain more than 13 characters or contain characters different from numbers
        if(!StringMatcherUtil.isValidPhoneNumber(user.getPhone())) {
            throw new InvalidPhoneNumberException("Invalid phone number");
        }

        // This exception is thrown when the document identification contain characters different from numbers
        if(!StringMatcherUtil.isNumeric(user.getDocumentID())) {
            throw new NumericException("Invalid document identification");
        }

        // This exception is thrown when the user is under 18 years old
        if(!CalendarUtil.isAdult(user.getBirthday())) {
            throw new UnderAgeException("Invalid birth date");
        }

        return userPersistencePort.saveUser(user);
    }
}
