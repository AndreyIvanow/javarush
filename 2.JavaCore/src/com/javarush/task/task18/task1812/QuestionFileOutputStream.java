package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream amigoOutputStreamImpl;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStreamImpl){
        this.amigoOutputStreamImpl = amigoOutputStreamImpl;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        amigoOutputStreamImpl.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        amigoOutputStreamImpl.flush();
    }

    @Override
    public void write(int b) throws IOException {
        amigoOutputStreamImpl.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        amigoOutputStreamImpl.write(b);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if ("Д".equals(answer)){
            amigoOutputStreamImpl.close();
        }
    }
}

