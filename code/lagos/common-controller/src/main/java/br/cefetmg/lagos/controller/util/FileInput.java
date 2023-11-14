package br.cefetmg.lagos.controller.util;

import br.cefetmg.lagos.controller.util.exception.InputException;

import javax.sql.rowset.serial.SerialBlob;
import java.io.InputStream;
import java.sql.Blob;

public class FileInput {
    public static byte[] readToBytes(InputStream inputStream) throws InputException {
        try {
            return inputStream.readAllBytes();
        } catch (Exception e) {
            throw new InputException(e.getMessage(), e);
        }
    }
}
