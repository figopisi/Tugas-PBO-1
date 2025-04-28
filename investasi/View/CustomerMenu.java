package View;

import java.util.Scanner;
import Service.Saham.TransactionSaham;
import Service.SBN.BuySBN;
import Service.SBN.SBNsimulation;
import Service.PortofolioService;
import View.Login.LoginMenu;

public class CustomerMenu {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        PortofolioService portfolioService = new PortofolioService();
        TransactionSaham transactionSaham = new TransactionSaham(portfolioService);
        BuySBN buySBN = new BuySBN(portfolioService);
        SBNsimulation sbnSimulation = new SBNsimulation();

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
                    transactionSaham.buySaham();
                    break;
                case "2":
                    transactionSaham.sellSaham();
                    break;
                case "3":
                    buySBN.buySBN();
                    break;
                case "4":
                    sbnSimulation.simulateSBNList();
                    break;
                case "5":
                    portfolioService.viewPortfolio();
                    break;
                case "6":
                    LoginMenu.menu();
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-6.");
            }
        }
    }
}
