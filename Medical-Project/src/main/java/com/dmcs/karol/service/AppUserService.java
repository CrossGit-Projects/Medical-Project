package com.dmcs.karol.service;

import com.dmcs.karol.domain.AppUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


public interface AppUserService {


    void saveUser(AppUser appUser);

    @PreAuthorize("hasRole('ROLE_ADMIN') OR (#appUser.login == principal.username)")
    void editAppUser(AppUser user);

    List<AppUser> listAppUser();

    @Secured("ROLE_ADMIN")
    void removeAppUser(long id);

    AppUser getAppUser(long id);

    AppUser findByEmail(String email);

    public void updateUserActivation(boolean activeCode, String activationCode);
}
