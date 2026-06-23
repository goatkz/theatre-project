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
            System.out.println("Предупреждение: Актёр " + actor + " уже участвует в спектакле \"" + title + "\".");
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
            System.out.println("Успешно: В спектакле \"" + title + "\" актёр с фамилией " + oldActorSurname + " заменен на " + newActor.getName() + " " + newActor.getSurname());
        } else {
            System.out.println("Предупреждение: Актёр с фамилией \"" + oldActorSurname + "\" не найден в спектакле \"" + title + "\".");
        }
    }


    public void printActors() {
        System.out.println("--- Список актеров спектакля \"" + title + "\" (Режиссёр: " + director + ") ---");
        if (listOfActors.isEmpty()) {
            System.out.println("В данном спектакле пока нет актеров.");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println("- " + actor);
            }
        }
    }
}