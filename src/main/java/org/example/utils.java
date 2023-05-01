package org.example;

public class utils {

    public static void delay(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    // Generate random string
    public static String randomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * chars.length());
            stringBuilder.append(chars.charAt(random));
        }
        return stringBuilder.toString();
    }

}
