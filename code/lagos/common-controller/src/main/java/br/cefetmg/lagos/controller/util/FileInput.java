package br.cefetmg.lagos.controller.util;

import br.cefetmg.lagos.controller.util.exception.InputException;

import javax.sql.rowset.serial.SerialBlob;
import java.io.InputStream;
import java.sql.Blob;

public class FileInput {
    public static Blob readToBlob(InputStream inputStream) throws InputException {
        try {
            byte[] bytes = inputStream.readAllBytes();
            return new SerialBlob(bytes);
        } catch (Exception e) {
            throw new InputException(e.getMessage(), e);
        }
    }
}
