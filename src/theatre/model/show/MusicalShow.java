package theatre.model.show;

import theatre.model.people.Director;

public class MusicalShow extends Show {
    private String musicAuthor;
    private String librettoText;

    public MusicalShow(String title, int duration, Director director, String musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println("--- Либретто к музыкальному спектаклю \"" + getTitle() + "\" (Автор музыки: " + musicAuthor + ") ---");
        System.out.println(librettoText);
    }
}