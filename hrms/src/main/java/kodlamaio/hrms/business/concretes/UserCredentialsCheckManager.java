package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UserCredentialsCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCredentialsCheckManager implements UserCredentialsCheckService {
    @Override
    public Result checkUserCredentials(User user) {
        // Email
        String email = user.getEmail();
        if(email == null || !isEmailValid(email)){
            return new ErrorResult("Email address error, please check your email address!");
        }
        // Password
        String password = user.getPassword();
        if ((password == null) || (password.length() < 6)){
            return new ErrorResult("Password should be at least 6 chars, please check your password!");
        }
        return new SuccessResult("Email and Password are valid!");
    }
    public boolean isEmailValid(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
