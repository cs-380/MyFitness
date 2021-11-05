
public class Components {
	private Food Parent_object;
	private String CHILD_CLASS_NAME;
	public Components(Food parent_object) {
		Parent_object = parent_object;
		if (parent_object.getTABLE_NAME().contains("MEAL")) {
			CHILD_CLASS_NAME = "FOOD_DATA";
		}
	}
	public Components(String child_class_name, Food parent_object) {
		Parent_object = parent_object;
		CHILD_CLASS_NAME = child_class_name;
	}
	public Portion[] get_All_Component() {
		Link[] link_IDs = Link.get_table_LINK_object(Parent_object.getTABLE_NAME(),Parent_object);
		Portion[] result_components = new Portion[link_IDs.length];
		for(int i = 0; i < link_IDs.length; i++) {
			result_components[i] = new Portion(
												new Food(CHILD_CLASS_NAME,link_IDs[i].getID_2()), 
												link_IDs[i].getPortion()
												);
		}
		return result_components;
	}
}
