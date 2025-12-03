package model;

public class Note {
    private int id;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;

    public Note(int id, String title, String content, String createdAt, String updatedAt) {
        this.id = id; //筆記編號
        this.title = title; //筆記標題
        this.content = content; //筆記內容
        this.createdAt = createdAt; //建立日期
        this.updatedAt = updatedAt; //修改日期
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}