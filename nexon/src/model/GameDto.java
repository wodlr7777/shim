package model;

public class GameDto {
	private int no;
	private String name;
	private String kind;
	private String format;
	private String gameinfo;
	
	public String getGameinfo() {
		return gameinfo;
	}
	public void setGameinfo(String gameinfo) {
		this.gameinfo = gameinfo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public GameDto(int no, String name, String kind, String format) {
		super();
		this.no = no;
		this.name = name;
		this.kind = kind;
		this.format = format;
	}
	public GameDto() {
		
	}
	
}
