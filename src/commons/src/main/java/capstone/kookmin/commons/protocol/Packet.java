package capstone.kookmin.commons.protocol;

/**
 * Coway Server와 통신하기 위한 표준 규격의 Packet 프로토콜 클래스
 * @author 이성준
 */
public class Packet {
	/***** Header *****/
	/**
	 * <li> 100: Success </li>
	 * <li> 200: Logical Error </li>
	 * <li> 300: System Error </li>
	 */
	private int statusCode;
	private int errorLines[];
	
	/***** Body *****/
	private String pseudoLines[];
	private String javaLines[];
	
	/**
	 * System Error인 경우: statusCode 만 존재한다.
	 * @param statusCode 상태코드(300)
	 */
	public Packet(int statusCode) {
		this.statusCode = statusCode;
	};
	
	/**
	 * Logical Error인 경우: statusCode와 빨간 줄 칠 errorLines, pseudoLines가 존재한다.
	 * @param statusCode 상태코드(200)
	 * @param errorLines 빨간 줄 칠 라인의 정보
	 * @param pseudoLines 수도코드
	 */
	public Packet(int statusCode, int errorLines[], String pseudoLines[]) {
		this.statusCode = statusCode;
		this.errorLines = errorLines;
		this.pseudoLines = pseudoLines;
	}
	
	/**
	 * Success인 경우: statusCode와 pseudoLines, javaLines가 존재한다.
	 * @param statusCode 상태코드(100)
	 * @param pseudoLines 변환전 수도코드
	 * @param javaLines 변환된 자바코드
	 */
	public Packet(int statusCode, String pseudoLines[], String javaLines[]) {
		this.statusCode = statusCode;
		this.pseudoLines = pseudoLines;
		this.javaLines = javaLines;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public int[] getErrorLines() {
		return errorLines;
	}
	public String[] getPseudoLines() {
		return pseudoLines;
	}
	public String[] getJavaLines() {
		return javaLines;
	}
}