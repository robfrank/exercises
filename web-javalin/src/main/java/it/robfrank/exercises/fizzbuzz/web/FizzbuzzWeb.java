package it.robfrank.exercises.fizzbuzz.web;

public class FizzbuzzWeb {

    public static void main(String[] args) {
        var app = new JavalinAppFactory().getApp();
        app.start(7070);
    }
}
