package com.inventory.api.security.util;

import com.inventory.api.domain.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SystemUser extends User {

    private Person person;

    public SystemUser(Person person, Collection<? extends GrantedAuthority> authorities) {
        super(person.getMail(), person.getPassword(), authorities);

        this.person = person;
    }

    public Person getPerson(){
        return person;
    }
}
