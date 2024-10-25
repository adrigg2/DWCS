package com.adrian.ej5.services;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
    private final Path rootLocation = Paths.get("uploadDir");

    @Autowired
    private JavaMailSender sender;

    @Override
    public String storeFile(MultipartFile file, String dni) throws RuntimeException {
        if (file.isEmpty()) throw new RuntimeException("Empty file");
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains("..")) throw new RuntimeException("Wrong file name");
        String extension = StringUtils.getFilenameExtension(filename);
        String storedFilename = dni + "." + extension;

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, this.rootLocation.resolve(storedFilename), StandardCopyOption.REPLACE_EXISTING);
            return storedFilename;
        } catch (IOException ioe) {throw new RuntimeException("Writing error");}
    }

    @Override
    public void SendEmail(String destination, String subject, String textMessage, String attachment) throws RuntimeException {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("adriangarcia@c8.daw1d.iesteis.gal");
            helper.setTo(destination);
            helper.setText(textMessage);
            helper.setSubject(subject);
            File attachedFile = new File(this.rootLocation.resolve(attachment).toString());
            helper.addAttachment(attachedFile.getName(), attachedFile);
            sender.send(message);
        } catch (MessagingException e) {throw new RuntimeException("Error when sending mail");}
    }
}
