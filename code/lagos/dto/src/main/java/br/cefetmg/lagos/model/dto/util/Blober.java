package br.cefetmg.lagos.model.dto.util;

import br.cefetmg.lagos.util.Serializer;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Blober {
    public static Blob parseFromFile(File file) throws SQLException, IOException {
        byte[] fileBytes = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(fileBytes);
        } catch (IOException e) {
            throw new IOException(e.getMessage(), e);
        }
        return new SerialBlob(fileBytes);
    }

    public static File parseToFile(Blob blob, String fileExtension) throws SQLException, IOException {
        InputStream in = blob.getBinaryStream();
        File tempFile = File.createTempFile("dtoblob_", fileExtension,
                new File(System.getProperty("java.io.tmpdir")));
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            byte[] buff = new byte[4096];
            int len;

            while ((len = in.read(buff)) != -1)
                out.write(buff, 0, len);

            tempFile.deleteOnExit();
            return tempFile;
        } catch (IOException e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    public static Blob parseFromList(ArrayList<?> list) throws IOException, SQLException {
        return new SerialBlob(Serializer.serialize(list));
    }

    public static ArrayList<?> parseToList(Blob blob) throws SQLException, IOException {
        return (ArrayList<?>) Serializer.deserialize(blob.getBytes(1, (int) blob.length()));
    }
}
