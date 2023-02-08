package gov.iti.jets.utils;

import gov.iti.jets.models.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ImageUtils {

    public static String storeImage(User user){
        try {
            Path filePath = Paths.get("appdata/" + user.getPhoneNumber() + "/profile" + user.getPictureExtension());
            Path parent = filePath.getParent();
            if (!Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.write(filePath,
                    user.getPicture(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] loadImage(String url){
        try {
            return Files.readAllBytes(Paths.get(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
