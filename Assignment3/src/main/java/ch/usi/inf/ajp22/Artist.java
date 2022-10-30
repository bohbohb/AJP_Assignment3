package ch.usi.inf.ajp22;

public class Artist {

    private String name;
    private String nickname;

    public Artist(String name) {
        this.name = name;
        this.nickname = "unknown";
    }

    public Artist(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
