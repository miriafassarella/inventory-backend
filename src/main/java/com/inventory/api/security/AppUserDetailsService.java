package com.inventory.api.security;

import com.inventory.api.domain.model.Person;
import com.inventory.api.domain.repository.PersonRepository;
import com.inventory.api.security.util.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;

    @Override // o método carrega pelo email do usuário.
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

        Optional<Person> personOptional = personRepository.findByMail(mail);
        Person person = personOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
        // Retorna email, senhas e permissões.

        //return new User(mail, person.getPassword(), getPermissoes(person));

        // Retornar UsuarioSistema para ser recuperado no CustomTokenEnhancer
        return new SystemUser(person, getPermissoes(person));

    }

    private Collection<? extends GrantedAuthority> getPermissoes(Person person) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        person.getPermission().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription()
                .toUpperCase())));

        return authorities;
    }


}
