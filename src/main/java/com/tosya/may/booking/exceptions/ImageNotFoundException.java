package com.tosya.may.booking.exceptions;

public class ImageNotFoundException extends NotFoundException {

    public ImageNotFoundException(int id) {
        super("No such image item with id " + id);
    }
}