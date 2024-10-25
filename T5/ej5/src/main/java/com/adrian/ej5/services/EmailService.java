package com.adrian.ej5.services;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    String storeFile(MultipartFile file, String dni) throws RuntimeException;
    void SendEmail(String destination, String subject, String textMessage, String attachment) throws RuntimeException;
}
