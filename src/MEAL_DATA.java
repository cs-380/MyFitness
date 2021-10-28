public class MEAL_DATA extends Food{
	private static String TABLE_NAME = "MEAL_DATA";
	private int ID;
	public MEAL_DATA() {
		super(TABLE_NAME);
	}
	public MEAL_DATA(int ID) {
		super(TABLE_NAME, ID);
	}
	public MEAL_DATA(Food new_food) {
		super(new_food);
	}
	public static MEAL_DATA typeToMEAL_DATA(Food food) {
		MEAL_DATA result = new MEAL_DATA(food);
		return result;
	}
	public static MEAL_DATA[] typeToMEAL_DATA(Food[] food) {
		MEAL_DATA[] result = new MEAL_DATA[food.length];
		for (int i =0; i < food.length; i++) {
			result[i] = MEAL_DATA.typeToMEAL_DATA(food[i]);
		}
		return result;
	}
	public static MEAL_DATA[] searching(String value_o_row) {
		return typeToMEAL_DATA(Food.searching(TABLE_NAME, value_o_row));
	}
    public String toString() {
        return "\n"
        		+ "***************************"  + "\n"
        		+"ID: "+ getID() + "\n"
        		+"Name: "+ getName() + "\n"
        		+"Calories: "+ getCalories() + "\n"	
        		+"Protein: "+ getProtein() + "\n"	
        		+"Carbs: "+ getCarbs() + "\n"
        		+"Sugars: "+ getSugars() + "\n"
        		+"Fiber: "+ getFiber() + "\n"
        		+"Fat: " + getFat()  + "\n"
        		+"***************************"  + "\n"
        		;
    }
    
    public double calorieCount(Food[] arr){
        double calories = 0;
    for (Food arr1 : arr) {
        calories += arr1.getCalories();
    }
    return calories;
}

    public double fatCount(Food[] arr){
        double fat = 0;
    for (Food arr1 : arr) {
        fat += arr1.getFat();
    }
    return fat;
}

    public double proteinCount(Food[] arr){
        double pro = 0;
    for (Food arr1 : arr) {
        pro += arr1.getProtein();
    }
    return pro;
}

    public double carbsCount(Food[] arr){
        double carbs = 0;
    for (Food arr1 : arr) {
        carbs += arr1.getCarbs();
    }
    return carbs;
}

    public double fiberCount(Food[] arr){
        double fib = 0;
    for (Food arr1 : arr) {
        fib += arr1.getFiber();
    }
    return fib;
}

}
