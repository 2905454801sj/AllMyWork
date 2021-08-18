package com.jason.thread2.Balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

public class BalkingData {
    private final String fileName;
    private String context;
    private boolean changed;

    public BalkingData(String fileName, String context) {
        this.fileName = fileName;
        this.context = context;
        this.changed=true;
    }
    public synchronized void change(String newcontext){
        this.context=newcontext;
        this.changed=true;
    }
    public synchronized void save() throws IOException {
        if(!changed){
            return ;
        }
        doSave();
        this.changed=false;
    }

    private void doSave() throws IOException {
        Optional.of(Thread.currentThread().getName()+" call save,context "+context).ifPresent(System.out::println);
        Writer writer=new FileWriter(fileName,true);
        writer.write(context);
        writer.write("\n");
        writer.flush();

    }
}
