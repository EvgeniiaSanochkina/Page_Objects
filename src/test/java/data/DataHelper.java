package data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {} // для невозможности создания экземпляра класса

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getCode() {
        return new VerificationCode("12345");
    }

    public static int generateAmount(int balance) {
        int amount = (new Random().nextInt(balance) + 1);
        return amount;
    }
}
