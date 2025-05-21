package com.inventory.api.controller;

import com.inventory.api.config.property.InventoryApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/tokens")
public class TokenController {

        @DeleteMapping("/revoke")
        public void revoke(HttpServletRequest req, HttpServletResponse resp) {
            Cookie cookie = new Cookie("refreshToken", null);
            cookie.setHttpOnly(true);
            cookie.setSecure(false); // TODO: em produção será true
            cookie.setPath(req.getContextPath() + "/oauth/token");
            cookie.setMaxAge(0);

            resp.addCookie(cookie);
            resp.setStatus(HttpStatus.NO_CONTENT.value());
        }
    }
