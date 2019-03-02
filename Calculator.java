package application;
public class Calculator{
	/*
	 * Simplified version of the calculator.java file from the first assignment,
	 * but with the scanner methods and menu removed. 
	 */
	static int x, y, num;
	static float m, n, result2;
	
	
	public static float addNumbers(float x, float y){
		result2 = x + y;
		return result2;
	}
	
	public static float subtractNumbers(float x, float y){
		result2 = x - y;
		return result2;	
	}
	
	public static float multiplyNumbers(float x, float y) {
		result2 = x * y;
		return result2;
	}
	
	public static float divideNumbers(float m, float n) {
		if(n==0) {
			return (float) -1.0;
			//Checks for 0 in the denominator
		}
		else {
			result2 = m / n;
			return result2;
		}
	}
	
	public static float squareRootNumber(float x) {
		float root = 1 ,inc = 1;
		if(x==0 || x==1) {
			result2=(float) x;
			return result2;
		}
		else {
			while(inc>.00002) {
				//this loop controls the decimal place that the inner loop is on
				while(root*root<=x) {
					//this loop incrementally searches for the square root
					//and stops once it has gone 1 too far
					root += inc;
				}
				root -= inc;
				inc = inc/10;
				//decimal place of inc moves 1 to the right
				if(root*root==x) {
					//catches perfect squares
					result2 = root;
					return result2;
				}
			}
			result2=root;
			return result2;
		}
	}
	
	public static float numberToPower(float x, float y) {
		if(y==0) {
			result2 = (float)1;
		}
		else if (y>=1) {
			int num = 1;
			for (int power = 1; power <= y; power++) {
				//multiplies num by x, y number of times
				num *= x;
			}
			result2 = (float) num;
		}
		else if (y<0) {
			//for negative powers does the same thing but takes the inverse
			int num = 1;
			for (int power = 1; power <= (y * -1); power++) {
				num *= x;
			}
			result2 =(float) 1/num;
		}
		return result2;
	}
	
	public static float getAbValue(float m) {
		if (m<0) {
			//if the number is negative, its multiplied by -1 to become positive
			result2 = m * -1;
		}
		else {
			result2 = m;
		}
		return result2;
	}
	
	public static float getFactorial(float x) {
		if(x==0) {
			result2 = 1;
		}
		else if(x<3) {
			result2 = x;
		}
		else {
			int factorial = 1;
			for (int factor = 2; factor <= x; factor++) {
				//multiplies the factorial variable by factor until factor
				//is equal to x
				factorial *= factor;
			}	
			result2 = factorial;
		}
		return result2;
	}
	
	public static float findFloor(float m) {
		//stores the values of the decimal in the float variable, then subtracts it off
		float decimal = m % 1;
		result2 = (m - decimal);
		return result2;
	}
	
	public static float findCeiling(float m) {
		float decimal = m % 1;
		result2 = (m - decimal + 1);
		return result2;
	}
	
}