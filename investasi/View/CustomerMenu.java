package View;

import java.util.Scanner;

    public class CustomerMenu {
        public static void showMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n==============================================");
                System.out.println("|              CUSTOMER MENU                 |");
                System.out.println("|============================================|");
                System.out.println("| 1. Beli Saham                              |");
                System.out.println("| 2. Jual Saham                              |");
                System.out.println("| 3. Beli SBN                                |");
                System.out.println("| 4. Simulasi SBN                            |");
                System.out.println("| 5. Portofolio                              |");
                System.out.println("| 6. Logout                                  |");
                System.out.println("==============================================");
                System.out.print("Pilih menu [1-6]: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Fitur Beli Saham belum diimplementasikan.");
                        break;
                    case "2":
                        System.out.println("Fitur Jual Saham belum diimplementasikan.");
                        break;
                    case "3":
                        System.out.println("Fitur Beli SBN belum diimplementasikan.");
                        break;
                    case "4":
                        System.out.println("Fitur Simulasi SBN belum diimplementasikan.");
                        break;
                    case "5":
                        System.out.println("Fitur Portofolio belum diimplementasikan.");
                        break;
                    case "6":
                        System.out.println("Logout berhasil.");
                        running = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-6.");
                }
            }
        }
    }

