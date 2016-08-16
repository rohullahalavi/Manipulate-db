package co.box.app.ru.www.manipulate;

public class StrucNote  {
    private String title;
    private String description;
    private boolean done;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone(int value) {
        done =false;
        if (value>=1) {
            done = true;
        }
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
