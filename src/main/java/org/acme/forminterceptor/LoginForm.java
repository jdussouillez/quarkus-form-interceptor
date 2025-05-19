package org.acme.forminterceptor;

import org.jboss.resteasy.reactive.RestForm;

public class LoginForm {

    @RestForm
    public String username;

    @RestForm
    public String password;

    @Override
    public String toString() {
        return "LoginForm{username='" + username + "', password='" + password + "'}";
    }
}
