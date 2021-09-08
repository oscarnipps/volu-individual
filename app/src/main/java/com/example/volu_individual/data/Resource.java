package com.example.volu_individual.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Resource<T> {

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    @NonNull
    public final Status status;

    public enum Status {
        LOADING,
        ERROR,
        SUCCESS
    }

    public Resource(@Nullable T data, @Nullable String message, @NonNull Status status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }


    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(data, null, Status.LOADING);
    }

    public static <T> Resource<T> error(@Nullable String message) {
        return new Resource<>(null, message, Status.ERROR);
    }

    public static <T> Resource<T> success(@Nullable T data, @Nullable String message) {
        return new Resource<>(data, message, Status.SUCCESS);
    }

}
