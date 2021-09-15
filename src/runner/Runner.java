package runner;


public class Runner {
    public static void main(String[] args) {
        AtmService atmService = new AtmService();
        atmService.start();
    }
}
