package project.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("ReplyVO")
public class ReplyVO {
	private String id;
	private Timestamp regDate;
	private String comments;
	private int seq;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
