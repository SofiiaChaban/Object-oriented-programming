package com.lab02;
import java.io.*;
import java.util.Iterator;
public class Container implements Serializable,Iterable<String>{
    public  String[] words;
    public int curLength=0;
    public Container(int length){
        if(length>0){
            words = new String[length];
        }
        else{
            System.out.println("ERROR");
        }
    }
    public String toString(){
        if(curLength==0){
            return null;
        }
        StringBuilder buildString = new StringBuilder();
        buildString.append("[");
        for(int i = 0;i<curLength;i++){
            buildString.append(words[i]);
            buildString.append(" , ");
        }
        buildString.append("]");
        return new String(buildString);
    }
    public void add(String string){
        if(curLength<max_size())
        words[curLength++]=string;
    }
    public void clear(){
        for(int i=0;i<words.length;i++){
            words[i]=null;
        }
        curLength=0;
    }
    public String[] toArray(){
        String[] array = new String[curLength];
        System.arraycopy(words,0,array,0,curLength);
        return array;
    }
    public boolean remove(String string){
        boolean check = false;
        for(int i=0;i<curLength;i++){
            if(check){
                words[i-1]=words[i];
            }
            else if(string.equals(words[i])){
                check = true;
            }
        }
        if(check){
            curLength--;
        }
        return check;
    }
    public boolean remove(int id){
        boolean checker = false;
        for(int i = 0; i < curLength;i++){
            if(checker){
                words[i-1] = words[i];
            }
            else if(this.words[id] != null){
                checker = true;
            }
        }
        if(checker){
            curLength--;
            return true;
        }
        else return false;
    }
    public int size(){
        return curLength;
    }
    public boolean contain(String string){
        boolean check = false;
        for(int i=0;i<curLength;i++){
            if(string.equals(words[i])){
                check = true;
            }
        }
        return check;
    }
    public boolean containsAll(Container cont1){
        for(int i=0;i<curLength;i++){
            boolean check = false;
            for(int j=0;j<cont1.size();j++){
                if(words[i].equals(cont1.words[i])){
                check=true;
                break;
                }
            }
            if(!check) return false;
        }
        return true;
    }
public String getElement(int index){
    if (index >= curLength ) {
        return null;
    }
    else
        return words[index];
}
public int getIndex(String string){
        for(int i=0;i<curLength;i++){
            if(words[i].equals(string)){
                return i;
            }

        }
        return -1;

}
    public int max_size(){
        return words.length;
    }
   public  boolean serialize(String fileName) {
        FileOutputStream fos;
        try{
            fos = new FileOutputStream(fileName);
        }
        catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            return false;
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            return  true;
        }
        catch (IOException e) {
            e.getMessage();
            return  false;
        }
    }

    public  boolean deserialize(String fileName){
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
        }
        catch (FileNotFoundException ex){
            ex.getMessage();
            return  false;
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Container container = (Container) ois.readObject();
            this.words = container.words;
            this.curLength = container.curLength;
            return  true;
        }
        catch (IOException | ClassNotFoundException e) {
            e.getMessage();
            return  false;
        }
    }
    public int compare(int id1,int id2){
        String str1 = words[id1];
        String str2 = words[id2];
        if(str1.length() != str2.length()){
            return str1.length() - str2.length();
        }
        for(int i = 0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return str1.charAt(i) - str2.charAt(i);
            }
        }
        return 0;
    }
    public void sort(){
        for(int i=0;i<curLength-1;i++){
            for(int j=0; j<curLength;j++){
                if(this.compare(i,j) > 0){
                    String temp=words[i];
                    words[i]=words[j];
                    words[j]=temp;
                }
            }
        }
    }
    @Override
    public Iterator<String> iterator() {
        return new Iteratormy(this,curLength);
    }
}
