package com.lab02;
import java.util.Iterator;
class Iteratormy implements Iterator<String> {
    private int cur=0;
    private int last;
    private Container cont;
    Iteratormy(Container cont1, int length){
    this.cont=cont1;
    last=length-1;
    }
    @Override
    public boolean hasNext(){
    return (cur<=last);
    }
    @Override
    public String next(){
        return cont.words[cur++];
    }
    @Override
    public void remove(){
        cont.remove(--cur);
        cont.remove(--last);
    }

}
