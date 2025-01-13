package com.example.relation.global.exception;

import org.springframework.web.multipart.MultipartException;

public class FileUploadException extends MultipartException {
    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException() {
        super("파일 업로드 실패.");
    }
}
