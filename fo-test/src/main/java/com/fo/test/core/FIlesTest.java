package com.fo.test.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FIlesTest {
    
    public static void main(String[] args) throws IOException {
        // move reconcile file
        Path sourcePath = Paths.get("/Users/bryce/test/b.md")
        .toAbsolutePath().normalize();
        Path targetPath = Paths.get("/Users/bryce/b.md")
                .toAbsolutePath().normalize();
        Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

}
