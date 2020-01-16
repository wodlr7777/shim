package paging;


public class Paging {
	private int pageNo;
	private int rowTotal;
	private int rowBlock;//한페이지에 표시되는 게시글수
	private int rowStart;
	private int rowEnd;
////////////////////////////////////////	
	private int pageTotal;
	private int pageBlock;//페이지번호 보여질 개수
	private int blockNo;
	private int pageStart;
	private int pageEnd;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getRowTotal() {
		return rowTotal;
	}
	public void setRowTotal(int rowTotal) {
		this.rowTotal = rowTotal;
	}
	public int getRowBlock() {
		return rowBlock;
	}
	public void setRowBlock(int rowBlock) {
		this.rowBlock = rowBlock;
	}
	public int getRowStart() {
		return rowStart;
	}
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}
	public int getRowEnd() {
		return rowEnd;
	}
	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(int blockNo) {
		this.blockNo = blockNo;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public Paging(int pageNo, int rowTotal) {
		super();
		this.pageNo = pageNo;
		this.rowTotal = rowTotal;
		this.pageNo = pageNo;
		this.rowTotal = rowTotal;
		this.rowBlock=5;//한 화면에 게시글 최대 10개
		this.rowStart=(pageNo-1)*rowBlock+1;
		this.rowEnd=rowStart+rowBlock-1;
		if(rowEnd>this.rowTotal) {
			rowEnd=this.rowTotal;
		}
		
		//페이지세팅
		this.pageTotal=rowTotal/rowBlock;
		if(rowTotal%rowBlock!=0) {
			this.pageTotal++;
		}
		this.blockNo=1;
		this.pageBlock=5; //한화면에 페이지 번호 최대 10개
		blockNo=pageNo/pageBlock;
		if(pageNo%pageBlock!=0) {
			blockNo++;
		}
		this.pageStart=(blockNo-1)*pageBlock+1;
		this.pageEnd=pageStart+pageBlock-1;
		if(pageEnd>pageTotal) {
			pageEnd=pageTotal;
		}
	}
	
}
