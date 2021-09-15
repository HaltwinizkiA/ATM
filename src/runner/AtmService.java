package runner;

import action.*;
import facade.Atm;
import menu.Menu;
import menu.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AtmService {
    private final Menu rootMenu;
    private final Menu mainMenu;

    public AtmService() {
        this.rootMenu = new Menu();
        this.mainMenu = new Menu();
        createMenu();
    }

    private  void  createMenu(){
     rootMenu.setName("ATM");
     List<MenuItem> rootItem=new ArrayList<>();
     rootItem.add(new MenuItem(new Login(),"Login"));
     rootItem.add(new MenuItem(new Exit(),"Exit"));
     rootMenu.setMenuItems(rootItem);

     mainMenu.setName("\nMenu:");
     List<MenuItem> mainItem=new ArrayList<>();
     mainItem.add(new MenuItem(new BalanceCheck(),"Chek Balance"));
     mainItem.add(new MenuItem(new Deposit(),"Deposit"));
     mainItem.add(new MenuItem(new Withdraw(),"Withdraw"));
     mainItem.add(new MenuItem(new Exit(),"Exit"));
     mainMenu.setMenuItems(mainItem);

    }
    public void start(){
       launchMenu(rootMenu);
       while (true){
       launchMenu(mainMenu);

       }
    }

    private void launchMenu(Menu menu){
        while (true) {
            printMenu(menu);
            Scanner scanner = new Scanner(System.in);
            try {
                int num = scanner.nextInt();
                menu.getMenuItems().get(num).getAction().execute();
                break;
            } catch (Exception e) {
                System.out.println("wrong input");
            }
        }
    }


    private void printMenu(Menu menu){
        int n=0;
        for (MenuItem item:menu.getMenuItems()){
            System.out.println(n+" - "+item.getName());
            n++;
        }

    }
}
