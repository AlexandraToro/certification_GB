package catalog;


import java.util.HashMap;
import java.util.Scanner;


public class program {
    private static HashMap<Integer, Animal> catalog= new HashMap<>();

    public static void main(String[] args) {
        menu();
    }
    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствуем вас в нашем каталоге животных");
        try {
            while (true) {
                System.out.println(
                        "Вам доступно: \n" +
                                "1 - посмотреть существующий каталог \n" +
                                "2 - добавить нового питомца \n" +
                                "3 - посмотреть команды, которые умеет исполнять питомец \n" +
                                "4 - добавить питомцу новые команды \n" +
                                "0 - выход");

                System.out.println("-> ");
                int button = scanner.nextInt();
                switch (button) {
                    case 0:
                        System.out.println("До новых встреч!");
                        scanner.close();
                        return;
                    case 1:
                        System.out.println(catalog);
                        break;
                    case 2:
                        registry.addAnimal(catalog);
                        break;
                    case 3:
                        registry.printCommand(catalog);
                        break;
                    case 4:
                        registry.addCommand(catalog);
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
        } catch (RuntimeException ex){
            System.out.println("Введен неправильный код, перезапустите приложение.");
        }
    }
}
