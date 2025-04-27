package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static int readInt(String prompt, int min, int max) {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(readString(prompt));
                if (value >= min && value <= max) return value;
                System.out.printf("Masukkan angka antara %d dan %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka desimal.");
            }
        }
    }

    public static LocalDate readDate(String prompt) {
        while (true) {
            try {
                return LocalDate.parse(readString(prompt + " (YYYY-MM-DD)"));
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal salah. Gunakan YYYY-MM-DD.");
            }
        }
    }
}
