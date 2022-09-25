package ctoy2work.example.tistorycomment.domain;

import java.time.LocalDateTime;

public class Comment {

    Long id; // 댓글 식별 번호
    String nickname; // 이름
    String password; // 암호
    String comment; // 댓글 내용
    LocalDateTime commentTime; // 댓글 작성 시간

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
