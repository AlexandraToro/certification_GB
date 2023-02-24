package catalog;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class registry {

    public static HashMap<Integer, Animal> addAnimal(HashMap<Integer, Animal> catalog) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя питомца ");
        String nickname = scanner.nextLine();
        System.out.println("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
        String birthdate = scanner.nextLine();
        System.out.println("Введите выполняемые команды через запятую, в конце нажмите Enter: ");
        String command = scanner.nextLine();
        System.out.println("Ваше животное является домашним? (да/нет) : ");
        String isPet = scanner.nextLine();
        try (counter c = new counter()) {
            if (isPet.equals("да")) {
                System.out.println("Если ваш питомец кот/кошка, введите 1. " + '\n'
                        + "Если ваш питомец собака, введите 2." + '\n'
                        + "Если ваш питомец хомяк, введите 3. " + '\n'
                        + "Если у вас другое домашнее животное, введите 0: ");
                int species = scanner.nextInt();
                switch (species) {
                    case 0:
                        System.out.println("Питомец будет добавлен в класс 'Домашние животные'\n");
                        Animal.Pet animal = new Animal.Pet(nickname, birthdate, command);
                        catalog.put(c.add(), animal);
                        break;
                    case 1:
                        Animal.Cats cat = new Animal.Cats(nickname, birthdate, command);
                        catalog.put(c.add(), cat);
                        break;
                    case 2:
                        Animal.Dogs dog = new Animal.Dogs(nickname, birthdate, command);
                        catalog.put(c.add(), dog);
                        break;
                    case 3:
                        Animal.Hamsters hamster = new Animal.Hamsters(nickname, birthdate, command);
                        catalog.put(c.add(), hamster);
                        break;
                    default:
                        throw new RuntimeException();
                }
            } else {
                System.out.println("Ваше животное является вьючным? (да/нет) : ");
                String isPack = scanner.nextLine();
                if (isPack.equals("да")) {
                    System.out.println("Если ваш питомец лошадь, введите 1. " + '\n'
                            + "Если ваш питомец верблюд, введите 2." + '\n'
                            + "Если ваш питомец осел, введите 3. " + '\n'
                            + "Если у вас другое вьючное животное, введите 0: ");
                    int species = scanner.nextInt();
                    switch (species) {
                        case 0:
                            System.out.println("Питомец будет добавлен в класс 'Вьючные животные'\n");
                            Animal.Pack animal = new Animal.Pack(nickname, birthdate, command);
                            catalog.put(c.add(), animal);
                            break;
                        case 1:
                            Animal.Horses horse = new Animal.Horses(nickname, birthdate, command);
                            catalog.put(c.add(), horse);
                            break;
                        case 2:
                            Animal.Camels camel = new Animal.Camels(nickname, birthdate, command);
                            catalog.put(c.add(), camel);
                            break;
                        case 3:
                            Animal.Donkeys donkey = new Animal.Donkeys(nickname, birthdate, command);
                            catalog.put(c.add(), donkey);
                            break;
                        default:
                            throw new RuntimeException();
                    }
                } else {
                    System.out.println("Питомец будет добавлен в общий класс 'Животные'.\n");
                    Animal animal = new Animal(nickname, birthdate, command);
                    catalog.put(c.add(), animal);
                }
            }
            System.out.println("Питомец добавлен в каталог.\n");
        } catch (RuntimeException ex) {
            System.out.println("Введен неправильный код");
        }
        return catalog;
    }

    public static void printCommand(HashMap<Integer, Animal> catalog) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> list = new ArrayList<>(catalog.values());
        System.out.println("Введите имя питомца ");
        String nickname = scanner.nextLine();
        System.out.println("Введите дату рождения: ");
        String birthdate = scanner.nextLine();
        boolean f = true;
        for (Animal anim : list) {
            if (anim.getName().equals(nickname) && anim.getBirthdate().equals(birthdate)) {
                System.out.println("Команды, которые выполняет питомец " + anim.getName() + ": " + anim.getCommands()+"\n");
                f = false;
            }
        }
        if (f) System.out.println("Питомца с такими данными нет в каталоге.\n");
    }

    public static void addCommand(HashMap<Integer, Animal> catalog) {
        List<Animal> list = new ArrayList<>(catalog.values());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя питомца ");
        String nickname = scanner.nextLine();
        System.out.println("Введите дату рождения: ");
        String birthdate = scanner.nextLine();
        boolean f = true;
        for (Animal anim : list) {
            if (anim.getName().equals(nickname) && anim.getBirthdate().equals(birthdate)) {
                System.out.println("Введите новые умения питомца через запятую: ");
                String newcom = scanner.nextLine();
                newcom = anim.getCommands().concat(", ").concat(newcom);
                anim.setCommands(newcom);
                System.out.println("Питомец " + anim.getName() + " теперь умеет: " + anim.getCommands()+"\n");
                f = false;
            }
        }
        if (f) System.out.println("Питомца с такими данными нет в каталоге \n");
    }
}
