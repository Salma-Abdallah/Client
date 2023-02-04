package gov.iti.jets.dto;

import com.mysql.cj.protocol.x.XMessage;

import java.sql.Timestamp;

public class MessagesDTO {


    private int id;
    private int authorId;
    private int chatId;
    private String fontStyle;
    private String fontColor;
    private double fontSize;
    private boolean bold;
    private boolean italic;
    private boolean underlined;
    private String textBackground;
    private Timestamp sentAt;
    private String content;
    private String fileUrl;

    public MessagesDTO(int id, int authorId, int chatId, String fontStyle, String fontColor, double fontSize,
                    boolean bold, boolean italic, boolean underlined, String textBackground,
                    Timestamp sentAt, String content, String fileUrl) {
        this.id = id;
        this.authorId = authorId;
        this.chatId = chatId;
        this.fontStyle = fontStyle;
        this.fontColor = fontColor;
        this.fontSize = fontSize;
        this.bold = bold;
        this.italic = italic;
        this.underlined = underlined;
        this.textBackground = textBackground;
        this.sentAt = sentAt;
        this.content = content;
        this.fileUrl = fileUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public double getFontSize() {
        return fontSize;
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean isUnderlined() {
        return underlined;
    }

    public void setUnderlined(boolean underlined) {
        this.underlined = underlined;
    }

    public String getTextBackground() {
        return textBackground;
    }

    public void setTextBackground(String textBackground) {
        this.textBackground = textBackground;
    }

    public Timestamp getSentAt() {
        return sentAt;
    }

    public void setSentAt(Timestamp sentAt) {
        this.sentAt = sentAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}