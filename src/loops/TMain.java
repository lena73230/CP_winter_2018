package loops;

public class TMain {
	public static void main(String[] args)
	{
		TProcess myExams = new TProcess();
		myExams.addActivity
			(new TActivity("Java Programming", 5.0));
		myExams.addActivity
			(new TActivity("Statistical Methods", 4.0));
		myExams.addActivity
			(new TActivity("Business Intelligence", 5.0));
		myExams.addActivity
			(new TActivity("Big Data", 3.0));
		
		myExams.showProcessState();

	}
}
