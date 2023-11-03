package br.cefetmg.lagos.model.dto.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String nome();
    Class<?> tipo();
}
