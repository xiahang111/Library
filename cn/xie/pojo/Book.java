package cn.xie.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键自增长策略
	private Integer BookId;
	
	@Column(name="BOOK_NAME")
	private String BookName;
	
	@Column(name="BOOK_AUTHOR")
	private String BookAuthor;
	
	@Column(name="BOOK_COUNT")
	private int BookCount;
	
	//图书简介
	@Column(name="BOOK_DESC")
	private String BookDesc;
	
	//图书状态
	@Column(name="BOOK_STATUS")
	private int BookStatus;

	public Integer getBookId() {
		return BookId;
	}

	public void setBookId(Integer bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookAuthor() {
		return BookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}

	public int getBookCount() {
		return BookCount;
	}

	public void setBookCount(int bookCount) {
		BookCount = bookCount;
	}

	public String getBookDesc() {
		return BookDesc;
	}

	public void setBookDesc(String bookDesc) {
		BookDesc = bookDesc;
	}

	public int getBookStatus() {
		return BookStatus;
	}

	public void setBookStatus(int bookStatus) {
		BookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", BookName=" + BookName + ", BookAuthor=" + BookAuthor + ", BookCount="
				+ BookCount + ", BookDesc=" + BookDesc + ", BookStatus=" + BookStatus + "]";
	}
	

	
	

}











