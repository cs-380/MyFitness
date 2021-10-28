public class FOOD_DATA extends Food{
	private static String TABLE_NAME = "FOOD_DATA";
	private int ID;
	public FOOD_DATA() {
		super(TABLE_NAME);
	}
	public FOOD_DATA(int ID) {
		super(TABLE_NAME, ID);
	}
	public FOOD_DATA(Food new_food) {
		super(new_food);
	}
	public static FOOD_DATA typeToFOOD_DATA(Food food) {
		FOOD_DATA result = new FOOD_DATA(food);
		return result;
	}
	public static FOOD_DATA[] typeToFOOD_DATA(Food[] food) {
		FOOD_DATA[] result = new FOOD_DATA[food.length];
		for (int i =0; i < food.length; i++) {
			result[i] = FOOD_DATA.typeToFOOD_DATA(food[i]);
		}
		return result;
	}
	public static FOOD_DATA[] searching(String value_o_row) {
		return typeToFOOD_DATA(Food.searching(TABLE_NAME, value_o_row));
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

}
