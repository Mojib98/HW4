package App;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    AdminApp adminApp = new AdminApp();
    private void admin(){
        boolean isRun =true;
        while (isRun){
            System.out.println("\t\tWelcome\n" +
                    "\tfor active menu insert 1\n" +
                    "\tfor deactive insert 2\n" +
                    "for show modle insert 3");
            int section = scanner.nextInt();
            switch (section){
                case 1:
                    adminApp.activeing();
                    break;
                case 2:
                    adminApp.detiveing();
                    break;
                case 3:
                    adminApp.show();
                    break;
                case 4:
                    isRun =false;
                    break;
            }
        }
    }
}
