package org.koreait;

class Article {
    private int id;
    private String getDate;
    private String text;
    private String author;

    public Article(int id, String getDate, String text, String author) {
        this.id = id;
        this.getDate = getDate;
        this.text = text;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return getDate;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}