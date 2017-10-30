package quizCozumler;

public class StopWatch {
	
	long start;
	
	public StopWatch(){
		start=System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		return (System.currentTimeMillis()-start)/1000;
	}

}
