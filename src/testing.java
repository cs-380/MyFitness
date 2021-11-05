
public class testing {

	public static void main(String[] args) {
		FOOD_DATA test_1 = new FOOD_DATA(11000000);
		test_1.set_new_ID(11100000);
		System.out.println(test_1);
		MEAL_DATA test_2 = new MEAL_DATA(141);
		LINK_MEAL_DATA test_3 = new LINK_MEAL_DATA(12);
		test_3.set_new_ID_1(141);
		test_3.set_new_ID_2(11000000);
		test_3.setPortion(3.5);
		test_3.set_new_ID(13);
		test_3.set_new_ID_1(141);
		test_3.set_new_ID_2(11100000);
		test_3.setPortion(2.5);
		Components temp = new Components(test_2);
		Portion[] temp_2 = temp.get_All_Component();
		for(int i = 0; i< temp_2.length; i++) {
			System.out.println(temp_2[i]);
		}
	}
}
