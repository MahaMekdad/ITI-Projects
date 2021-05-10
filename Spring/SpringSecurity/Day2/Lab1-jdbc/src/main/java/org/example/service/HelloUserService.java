package org.example.service;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.example.model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

public interface HelloUserService {

    @Secured(value = {"ROLE_USER"})
    void userAccessMethod(String name);

    @Secured(value = {"ROLE_ADMIN"})
    void adminAccessMethod(String name);

    @Secured(value = {"ROLE_MANAGER"})
    void managerAccessMethod(String name);

    @Secured(value = {"ROLE_TEST1", "ROLE_TEST2"})
    void testAccessMethod(String name);

    // @PermitAll
    // void allAccessMethod(String name);

    @RolesAllowed("ROLE_ADMIN")
    void allAccessMethod(String name);

    // @PreAuthorize("hasAuthority('ROLE_MANAGER') and #name.length() <= 4")
    // @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    void managerPreAuthAccessMethod(String name);

    // @PreFilter("filterObject == authentication.name")
    // @PreFilter("filterObject == maha")
    // List<String> getNames(String name);

    // @PostFilter("hasAuthority('ROLE_MANAGER') and filterObject.name.length() == 4")
    List<User> getNames(String name);

    void testPoint(String n);
    
}
