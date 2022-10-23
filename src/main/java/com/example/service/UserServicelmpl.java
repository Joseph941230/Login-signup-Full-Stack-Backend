package com.example.service;


import com.example.controller.Resp;
import com.example.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
public class UserServicelmpl implements UserService {
    @Resource
    private UserRepo userRepo;


    /**
     * -1: validate inout
     * -2: user exists;
     * -3: password not valid;
     */
    @Override
    public int signup(IdentityParameters identityParameters) {
        String userName = identityParameters.getName();
        String password = identityParameters.getPasswd();
        String email = identityParameters.getEmail();
        String phone = identityParameters.getPhone();

        boolean isPhoneVaild = StringUtils.isNumeric(phone);
        boolean isEmailVaild = StringUtils.containsAny(email, "@");
        boolean isPasswordVaild = StringUtils.length(password) > 5;
        boolean isUserNameVaild = StringUtils.isNotEmpty(userName);
        if (!isPhoneVaild) {
            return -6;
        }
        if (!isEmailVaild) {
            return -5;
        }
        if (!isPasswordVaild) {
            return -4;
        }
        if (!isUserNameVaild) {
            return -3;
        }

        //Step2

        boolean isSameEmailFound = userRepo.findUserByEmail(email) != null;
        boolean isSamephoneFound = userRepo.findUserByPhone(phone) != null;

        if (isSameEmailFound || isSamephoneFound) {

            return -2;
        }
        User newUser = new User();
        newUser.setName(userName);
        newUser.setPasswd(password);
        newUser.setPhone(phone);
        newUser.setEmail(email);

        userRepo.save(newUser);


        return 0;
    }

    @Override
    public void login(IdentityParameters identityParameters) throws UserException {

    }


}
