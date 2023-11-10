package br.cefetmg.lagos.controller;

import br.cefetmg.lagos.controller.exception.OutputException;
import net.sf.jmimemagic.Magic;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;

public class FileOutput {

    /**
     * Writes the str to the outputStream.
     * @param str A str to be written to output
     * @param outputStream The OutputStream where to write the string
     */
    public static void writeToOutput(String str, OutputStream outputStream) throws OutputException {
        writeToOutput(str.getBytes(StandardCharsets.UTF_8), outputStream);
    }

    /**
     * Writes the blob to the outputStream.
     * @param blob A blob to be written to output
     * @param outputStream The OutputStream where to write the string
     */
    public static void writeToOutput(Blob blob, OutputStream outputStream) throws OutputException {
        try {
            byte[] blobBytes = blob.getBytes(1, (int) blob.length());
            writeToOutput(blobBytes, outputStream);
        } catch (Exception e) {
            throw new OutputException(e.getMessage(), e);
        }
    }

    public static void writeToOutput(byte[] bytes, OutputStream outputStream) throws OutputException {
        try {
            outputStream.write(bytes);
        } catch (Exception e) {
            throw new OutputException(e.getMessage(), e);
        }
    }

    public static void writeToOutput(Object object, OutputStream outputStream) throws OutputException {
        if (Blob.class.isAssignableFrom(object.getClass()))
            writeToOutput((Blob) object, outputStream);
        else if (String.class.isAssignableFrom(object.getClass()))
            writeToOutput((String) object, outputStream);
        else if (byte[].class.isAssignableFrom(object.getClass()))
            writeToOutput((byte[]) object, outputStream);
    }

    public static String getMimeType(byte[] bytes) throws OutputException {
        try {
            return Magic.getMagicMatch(bytes).getMimeType();
        } catch (Exception e) {
            throw new OutputException(e.getMessage(), e);
        }
    }

    public static String getMimeType(String string) throws OutputException {
        return getMimeType(string.getBytes(StandardCharsets.UTF_8));
    }

    public static String getMimeType(Blob blob) throws OutputException {
        try {
            return getMimeType(blob.getBytes(1, (int) blob.length()));
        } catch (Exception e) {
            throw new OutputException(e.getMessage(), e);
        }
    }
}
