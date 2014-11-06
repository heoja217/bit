package java02.score;

public class Score implements Cloneable {
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private float aver;
	
	public Score() {}
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		compute();
	}
	
	public Score(String csv) {
		String[] token = csv.split(",");
		this.name = token[0];
		this.kor = Integer.parseInt(token[1]);
		this.eng = Integer.parseInt(token[2]);
		this.math = Integer.parseInt(token[3]);
		compute();
	}
	public void compute() {

	    this.sum = kor + eng + math;
	    this.aver = sum / 3.0f;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSum() {
		return sum;
	}
	public float getAver() {
		return aver;
	}

	
	
	
	
}
