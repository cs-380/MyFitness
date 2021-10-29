public class LINK_MEAL_DATA extends Link{
	private static String TABLE_NAME = "LINK_MEAL_DATA";
	private int ID;
	public LINK_MEAL_DATA() {
		super(TABLE_NAME);
	}
	public LINK_MEAL_DATA(int ID) {
		super(TABLE_NAME, ID);
	}
	public LINK_MEAL_DATA(Link new_food) {
		super(new_food);
	}
	public static LINK_MEAL_DATA typeToLINK_MEAL_DATA(Link food) {
		LINK_MEAL_DATA result = new LINK_MEAL_DATA(food);
		return result;
	}
	public static LINK_MEAL_DATA[] typeToLINK_MEAL_DATA(Link[] food) {
		LINK_MEAL_DATA[] result = new LINK_MEAL_DATA[food.length];
		for (int i =0; i < food.length; i++) {
			result[i] = LINK_MEAL_DATA.typeToLINK_MEAL_DATA(food[i]);
		}
		return result;
	}
	public static MEAL_DATA[] get_table_LINK(MEAL_DATA food_table) {
		return MEAL_DATA.typeToMEAL_DATA(Link.get_table_LINK(TABLE_NAME, food_table));
	}

    public String toString() {
        return "\n"
        		+ "***************************"  + "\n"
        		+"ID: "+ getID() + "\n"
        		+"Description: "+ getDescription() + "\n"
                +"ID_1: "+ getID_1() + "\n"
        		+"ID_2: "+ getID_2() + "\n"
        		+"Portion: "+ getPortion() + "\n"
        		+"***************************"  + "\n"
        		;
    }

}