package util;

public class Common {
	//여러가지 기능들을 편리하게 관리하기 위해서 설정용 클래스를
	//따로 만듦
	
	//경로
	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	//일반 게시판용
	public static class Board {
		//한 페이지에 보여줄 게시물 개수
		public final static int BLOCKLIST = 10; //상수이므로 값은 바뀌지 않음
		
		//페이지 메뉴 개수
		public final static int BLOCKPAGE = 3;
		
		//Common.Board.BLOCKLIST; -> 10
	}
	
	//공지사항용
	public static class Notice {
		public final static int BLOCKLIST = 20;
		
		public final static int BLOCKPAGE = 5;
	}
}
