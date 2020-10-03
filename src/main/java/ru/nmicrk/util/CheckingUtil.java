package ru.nmicrk.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckingUtil {

    public static final String YEAR_CONTAIN_FILE = "Year folder should only contain volume folders, but %s is file.";
    public static final String ROOT_CONTAIN_FILE = "Root folder should only contain year folders, but %s is file.";
    public static final String FOLDER_IS_NOT_EXIST = "Folder %s does not exists";

    private CheckingUtil() {
        super();
    }

    public static void isDirectory(File file, String exceptionMessage) throws IllegalArgumentException {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format(exceptionMessage, file.getName()));
        }
    }

    public static void isFileExists(String folderPath) throws NoSuchFileException {
        Path magazineFolder = Paths.get(folderPath).toAbsolutePath();
        if (Files.notExists(magazineFolder)) {
            throw new NoSuchFileException(String.format(FOLDER_IS_NOT_EXIST, folderPath));
        }
    }
}
