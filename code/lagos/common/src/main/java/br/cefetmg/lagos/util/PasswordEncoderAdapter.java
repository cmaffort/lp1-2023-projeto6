package br.cefetmg.lagos.util;

public class PasswordEncoderAdapter {
    public String encode(String password) {
        return password;
    }

    public boolean matches(String password, String encodedPassword) {
        return true;
    }
}
