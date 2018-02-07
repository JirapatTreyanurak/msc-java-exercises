/** Worksheet 2 Exercise 1
 * 
 * This class contains a static method that
 * computes whether the student pass or fail
 * the Software Workshop module.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-16
 */
public class Ex1 {
	
	/**
	 * Computes whether the results in the Software
	 * Workshop module are sufficient to pass or not.
	 * 
	 * The student passes if the weighted score is
	 * greater than or equal to 50 (for MSc students),
	 * or 40 (for ICY students).
	 * 
	 * The module assessments and their weights are:
	 * <pre>
	 * Continuous Assessment 1    12.5%
	 * Continuous Assessment 2     7.5%
	 * Exam                       70%
	 * Team work                  10%
	 * </pre>
	 * 
	 * The method returns false if the student does
	 * not meet the grade requirement, or if the input
	 * score is outside of the [0,100] range. The 
	 * method also returns false if the student
	 * category is neither "MSc" or "ICY".
	 * 
	 * 
	 * @param continuousAssessment1 0 to 100 score contributing 12.5% to the overall grade.
	 * @param continuousAssessment2 0 to 100 score contributing 7.5% to the overall grade.
	 * @param exam 0 to 100 score contributing 70% to the overall grade.
	 * @param teamWork 0 to 100 score contributing 10% to the overall grade.
	 * @param studentCategory "MSc" for Masters students or "ICY" for year-in-computer-science students.
	 * @return Boolean whether the student pass or fail the module.
	 */
	public static boolean hasPassed (int continuousAssessment1, int continuousAssessment2, int exam, int teamWork, String studentCategory) {
		double weightedAverage;
		
		if (continuousAssessment1 > 100 || continuousAssessment1 < 0
		 || continuousAssessment2 > 100 || continuousAssessment2 < 0
		 || exam > 100 || exam < 0
		 || teamWork > 100 || teamWork < 0
		 || (!studentCategory.equals("MSc") && !studentCategory.equals("ICY")) ) {
			return false;
		}
		
		weightedAverage = (0.125*continuousAssessment1) + (0.075*continuousAssessment2) + (0.7*exam) + (0.1*teamWork);
		
		if (studentCategory.equals("MSc") && weightedAverage >= 50) {
			return true;
		}
		if (studentCategory.equals("ICY") && weightedAverage >= 40) {
			return true;
		}
		
		return false;
	}
	
}
