package cn.xie.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user_book")
public class MessBook {
	
	@Id
	private Integer userId;
	
	@Id
	private Integer bookId;
	
	@Column(name="BORROWTIME")
	private String borrowTime;
	
	
	@Column(name="RETURNTIME")
	private String returnTime;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public String getBorrowTime() {
		return borrowTime;
	}


	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}


	public String getReturnTime() {
		return returnTime;
	}


	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	
	

	
}
