import java.io.Serializable;
public class Composition implements Serializable {
    private String name;
    private String author;
    private String genre;
    private String text;
    private String date;
    private int duration;
    private String dataFormat;
    private byte rating;
    public Composition(){

    }
    public Composition(String name,String author,String genre, String date,int duration,String dataFormat,byte rating){
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
    public void setDuration(int duration){
        this.duration=duration;
    }
    public int getDuration(){
        return duration;
    }
    public byte getRating(){
        return rating;
    }
    public void setRating(byte rating){
        this.rating=rating;
    }
}
