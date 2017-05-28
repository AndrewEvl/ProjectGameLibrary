package entities;

/**
 * Created by User on 23.05.2017.
 */
public class ForumTheme {
    private String theme;
    private long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumTheme that = (ForumTheme) o;

        if (id != that.id) return false;
        return theme != null ? theme.equals(that.theme) : that.theme == null;
    }

    @Override
    public int hashCode() {
        int result = theme != null ? theme.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ForumTheme{" +
                "theme='" + theme + '\'' +
                ", id=" + id +
                '}';
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
