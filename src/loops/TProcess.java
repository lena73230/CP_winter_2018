package loops;
import java.util.ArrayList;

public class TProcess {
	TProcess(){
		ActivityList = new ArrayList<TActivity>();
		this.noActivities = 0;
	}
	public void addActivity(TActivity arg){
		ActivityList.add(arg);
		this.noActivities++;
	}
	public void showProcessState(){
		System.out.println("Here is the list of my exams:");
		for (TActivity TemporaryActivity : ActivityList) {
			TemporaryActivity.showActivityState();
		}
		System.out.println("Mean grade of my exams = " + computeMeanValue());
	}
	private double computeMeanValue(){
		double sumTemp = 0.0;
		for (TActivity TemporaryActivity : ActivityList) {
			sumTemp = sumTemp 
					+ TemporaryActivity.getActivityGrade();
		}
		return sumTemp/this.noActivities;
	}
	
	private ArrayList<TActivity> ActivityList;
	private int noActivities;
}
