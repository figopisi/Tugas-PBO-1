package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
        public static void menu() {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Login> accounts = new ArrayList<>();

            accounts.add(new Admin("admin", "admin123"));
            accounts.add(new User("user1", "user123"));

            boolean running = true;

            while (running) {
                System.out.println("\n==== MENU ====");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1": // LOGIN
                        System.out.print("Masukkan username: ");
                        String usernameLogin = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String passwordLogin = scanner.nextLine();

                        boolean found = false;

                        for (Login account : accounts) {
                            if (account.authenticate(usernameLogin, passwordLogin)) {
                                if (account instanceof Admin) {
                                    ((Admin) account).showDashboard();
                                } else if (account instanceof User) {
                                    ((User) account).showDashboard();
                                }
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Login gagal! Username atau password salah.");
                        }
                        break;

                    case "2": // REGISTER
                        System.out.print("Masukkan username baru: ");
                        String newUsername = scanner.nextLine();

                        boolean usernameExists = false;
                        for (Login account : accounts) {
                            if (account.getUsername().equals(newUsername)) {
                                usernameExists = true;
                                break;
                            }
                        }

                        if (usernameExists) {
                            System.out.println("Username sudah terdaftar. Silakan pilih username lain.");
                        } else {
                            System.out.print("Masukkan password baru: ");
                            String newPassword = scanner.nextLine();
                            System.out.println("Registrasi berhasil! Akun user baru telah dibuat.");
                        }
                        break;

                    case "3":
                        running = false;
                        System.out.println("Terima kasih! Program selesai.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
            scanner.close();
        }
    }
