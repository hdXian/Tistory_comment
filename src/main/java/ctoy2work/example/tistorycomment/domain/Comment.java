package ctoy2work.example.tistorycomment.domain;

import java.time.LocalDateTime;

public class Comment {

    Long id; // 댓글 식별 번호
    String nickname; // 이름
    String password; // 암호
    String commentText; // 댓글 내용
    String commentTime; // 댓글 작성 시간

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
