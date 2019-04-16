import java.io.*;
public class Composition implements Serializable {
    private String name;
    private String author;
    private String genre;
    private String text;
    private String date;
    private int duration;
    private String dataFormat;
    private byte rating;

    public Composition() {

    }

    public Composition(String name, String author, String genre, String date, int duration, String dataFormat, byte rating) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        // this.text=text;
        this.date = date;
        this.duration = duration;
        this.dataFormat = dataFormat;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        str.append("Name:").append(name).append("\n");
        str.append("Author:").append(author).append("\n");
        str.append("Genre:").append(genre).append("\n");
        str.append("Date:").append(date).append("\n");
        str.append("Duration:").append(duration).append("\n");
        str.append("Data Format:").append(dataFormat).append("\n");
        str.append("Rating:").append(rating).append("\n");
        str.append("Text:").append(text).append("\n");
        str.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        return str.toString();
    }
    public boolean serialize(String fileName) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            return true;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean deserialize(String fileName) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Composition composition = (Composition) ois.readObject();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getCause());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return false;
        } catch (ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
            System.out.println(exc.getCause());
            return false;
        }
    }
}
