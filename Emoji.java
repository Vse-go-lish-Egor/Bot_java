import com.vdurmont.emoji.EmojiParser;
public enum Emoji {
    SMILE (":grin:"),
    TALK (":speaking_head_in_silhouette:"),
    BACK(":arrow_backward:"),
    QUESTION(":question:"),
    MICROPHONE(":studio_microphone:"),
    CLOWN(":clown_face:"),
    CLOCK(":clock1:"),
    WTF(":open_mouth:");
    private String value;



    public String get(){
        return EmojiParser.parseToUnicode(value);
    }
    Emoji(String value) {
        this.value = value;
    }

}