package theatre.model.show;

import theatre.model.people.Actor;
import theatre.model.people.Director;

import java.util.ArrayList;
import java.util.List;

public class Show {

    private String title;
    private int duration; // в минутах
    private Director director;
    private List<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println(String.format("Предупреждение: Актёр %s уже участвует в спектакле \"%s\".", actor, title));
        } else {
            listOfActors.add(actor);
        }
    }

    public void replaceActor(Actor newActor, String oldActorSurname) {
        int indexToReplace = -1;
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equalsIgnoreCase(oldActorSurname)) {
                indexToReplace = i;
                break;
            }
        }

        if (indexToReplace != -1) {
            listOfActors.set(indexToReplace, newActor);
            System.out.println(String.format("Успешно: В спектакле \"%s\" актёр с фамилией %s заменен на %s %s", title, oldActorSurname, newActor.getName(), newActor.getSurname()));
        } else {
            System.out.println(String.format("Предупреждение: Актёр с фамилией \"%s\" не найден в спектакле \"%s\".", oldActorSurname, title));
        }
    }

    public void printActors() {
        System.out.println(String.format("--- Список актеров спектакля \"%s\" (Режиссёр: %s) ---", title, director));

        if (listOfActors.isEmpty()) {
            System.out.println("В данном спектакле пока нет актеров.");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println(String.format("- %s", actor));
            }
        }
    }
}