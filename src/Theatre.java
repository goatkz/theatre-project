import theatre.model.people.Gender;
import theatre.model.show.MusicalShow;
import theatre.model.show.Opera;
import theatre.model.show.Show;
import theatre.model.people.Actor;
import theatre.model.show.Ballet;
import theatre.model.people.Director;

import java.util.Scanner;

public class Theatre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Director director1 = new Director("Лев", "Додин", Gender.MALE, 45);
        Director director2 = new Director("Юрий", "Бутусов", Gender.MALE, 30);


        Opera dramaticShow = new Opera("Гамлет", 120, director1, "Амбруаз Тома (автор пьесы: Уильям Шекспир)", "Месть принца Гамлета за убийство отца, его безумие и трагическая любовь к Офелии.", 50);

        Opera operaShow = new Opera("Травиата", 180, director2, "Джузеппе Верди", "История куртизанки Виолетты Валери, ее трагической любви к Альфреду.", 80);

        Ballet balletShow = new Ballet("Лебединое озеро", 150, director1, "Пётр Чайковский", "Заколдованная принцесса Одетта в образе лебедя и принц Зигфрид.", "Мариус Петипа");

        System.out.println("Добро пожаловать в систему управления театром!");

        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1. Добавить актера в спектакль");
            System.out.println("2. Заменить актера в спектакле");
            System.out.println("3. Показать список актеров спектакля");
            System.out.println("4. Показать либретто (для Оперы/Балета)");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Программа завершена. До свидания!");
                break;
            }


            Show selectedShow = null;


            if (choice >= 1 && choice <= 4) {
                System.out.println("\nВыберите спектакль:");
                System.out.println("1. Драма \"Гамлет\"");
                System.out.println("2. Опера \"Травиата\"");
                System.out.println("3. Балет \"Лебединое озеро\"");
                System.out.print("Ваш выбор: ");
                int showChoice = scanner.nextInt();
                scanner.nextLine();

                switch (showChoice) {
                    case 1:
                        selectedShow = dramaticShow;
                        break;
                    case 2:
                        selectedShow = operaShow;
                        break;
                    case 3:
                        selectedShow = balletShow;
                        break;
                    default:
                        System.out.println("Неверный выбор спектакля!");
                        continue;
                }
            }


            switch (choice) {
                case 1:
                    System.out.print("Введите имя актера: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите фамилию актера: ");
                    String surname = scanner.nextLine();

                    System.out.print("Введите пол (1 - М, 2 - Ж): ");
                    int genderChoice = scanner.nextInt();
                    Gender gender = (genderChoice == 2) ? Gender.FEMALE : Gender.MALE;

                    System.out.print("Введите рост актера (см): ");
                    int height = scanner.nextInt();
                    scanner.nextLine();

                    Actor newActor = new Actor(name, surname, gender, height);
                    selectedShow.addActor(newActor);
                    break;

                case 2:
                    System.out.print("Введите ФАМИЛИЮ актера, которого нужно заменить: ");
                    String oldSurname = scanner.nextLine();

                    System.out.println("--- Введите данные КТО его заменит ---");
                    System.out.print("Имя нового актера: ");
                    String newName = scanner.nextLine();
                    System.out.print("Фамилия нового актера: ");
                    String newSurname = scanner.nextLine();
                    System.out.print("Пол нового актера (1 - М, 2 - Ж): ");
                    int newGenderChoice = scanner.nextInt();
                    Gender newGender = (newGenderChoice == 2) ? Gender.FEMALE : Gender.MALE;
                    System.out.print("Рост нового актера (см): ");
                    int newHeight = scanner.nextInt();
                    scanner.nextLine();

                    Actor replacementActor = new Actor(newName, newSurname, newGender, newHeight);
                    selectedShow.replaceActor(replacementActor, oldSurname);
                    break;

                case 3:
                    selectedShow.printActors();
                    break;

                case 4:
                    if (selectedShow instanceof MusicalShow) {

                        ((MusicalShow) selectedShow).printLibretto();
                    } else {
                        System.out.println("У драматического спектакля \"" + selectedShow.getTitle() + "\" нет либретто!");
                    }
                    break;

                default:
                    System.out.println("Неверный пункт меню! Попробуйте еще раз.");
            }
        }
        scanner.close();
    }
}