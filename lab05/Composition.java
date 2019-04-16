import java.io.Serializable;
public class Composition implements Serializable {
    private String name;
    private String author;
    private String genre;
    private String text;
    private String date;
    private String  duration;
    private String dataFormat;
    private String rating;
    public Composition(){

    }
    public Composition(String name,String author,String genre, String date,String  duration,String dataFormat,String rating){
        this.name=name;
        this.author=author;
        this.genre=genre;
        // this.text=text;
        this.date=date;
        this.duration=duration;
        this.dataFormat=dataFormat;
        this.rating=rating;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text=text;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getDataFormat(){
        return dataFormat;
    }
    public void setDataFormat(String dataFormat){
        this.dataFormat=dataFormat;
    }
    public void setDuration(String duration){
        this.duration=duration;
    }
    public String getDuration(){
        return duration;
    }
    public String getRating(){
        return rating;
    }
    public void setRating(String rating){
        this.rating=rating;
    }
}