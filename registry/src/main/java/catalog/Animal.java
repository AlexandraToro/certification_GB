package catalog;

import java.util.Objects;

public class Animal {

    protected String name;
    protected String birthdate;
    protected String commands;

    public Animal(String name, String birthdate, String commands) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    public Animal(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return " Животное: "
                + " имя - " + this.name
                + ",  дата рождения - " + this.birthdate
                + ",  выполняемые команды - " + this.commands + "\n";
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(birthdate, animal.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, commands);
    }

    public static class Pet extends Animal {

        public Pet(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Домашнее животное: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + ". Теперь дома всегда ждет друг. \n";
        }
    }

    public static class Pack extends Animal {

        public Pack(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Вьючное животное: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + ". Может покатать.\n)";
        }
    }

    public static class Cats extends Pet {

        public Cats(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Кошка|кот: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + "." + "\n";
        }
    }

    public static class Dogs extends Pet {
        public Dogs(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Собака: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + "." + "\n";
        }
    }

    public static class Hamsters extends Pet {
        public Hamsters(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Хомяк: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + "." + "\n";
        }
    }

    public static class Horses extends Pack {
        public Horses(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Лошадь|конь: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + "." + "\n";
        }
    }

    public static class Camels extends Pack {
        public Camels(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Верблюд: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + "." + "\n";
        }
    }

    public static class Donkeys extends Pack {
        public Donkeys(String name, String birthdate, String commands) {
            super(name, birthdate, commands);
        }

        @Override
        public String toString() {
            return " Осел: "
                    + " имя - " + this.name
                    + ", дата рождения - " + this.birthdate
                    + ", выполняемые команды - " + this.commands
                    + "." + "\n";
        }
    }
}
