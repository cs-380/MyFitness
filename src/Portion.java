import java.text.DecimalFormat;

public class Portion {
	private Food Item;
	private double Portion_size;
	private final double Portion_DEFAULT = 100.0;
	private double conversion_DEFAULT = 1;
	private double conversion_size = 1;
	private int ID = 0;
	private String Name = "";
	private String Description = "";
	private double Calories = 0;
	private double Protein = 0;
	private double Carbs = 0;
	private double Sugars = 0;
	private double Fiber = 0;
	private double Fat = 0;
	private double Fatty_acids_sat = 0;
	private double Fatty_acids_mon = 0;
	private double Fatty_acids_pol = 0;
	private double Cholesterol = 0;
	private double Retinol = 0;
	private double Vitamin_A = 0;
	private double Carotene_al = 0;
	private double Carotene_be = 0;
	private double Cryptoxanthin = 0;
	private double Lycopene = 0;
	private double Lutein_with_zeaxanthin = 0;
	private double Thiamin = 0;
	private double Riboflavin = 0;
	private double Niacin = 0;
	private double Vitamin_B6 = 0;
	private double Folic_acid = 0;
	private double Folate_food = 0;
	private double Folate_DFE = 0;
	private double Folate_total = 0;
	private double Choline = 0;
	private double Vitamin_B12 = 0;
	private double Vitamin_B12_added = 0;
	private double Vitamin_C = 0;
	private double Vitamin_D = 0;
	private double Vitamin_E = 0;
	private double Vitamin_E_added = 0;
	private double Vitamin_K = 0;
	private double Calcium = 0;
	private double Phosphorus = 0;
	private double Magnesium = 0;
	private double Iron = 0;
	private double Zinc = 0;
	private double Copper = 0;
	private double Selenium = 0;
	private double Potassium = 0;
	private double Sodium = 0;
	private double Caffeine = 0;
	private double Theobromine = 0;
	private double Alcohol = 0;
	private double Water = 0;
	public Portion(String tableName) {
		this(new Food(tableName), 0);
	}
	public Portion(Food item, double size) {
		setItem(item);
		setPortion_size(size);
		if(size != 0) {
			conversion_DEFAULT = Portion_DEFAULT/size;
			conversion_size = size/Portion_DEFAULT;
		}
		get_Food_to_size();
	}
	private void get_Food_to_size() {
		ID = Item.getID();
		Name = Item.getName() ;
		Description = Item.getDescription() ;
		Calories = Item.getCalories()*conversion_size;
		Protein = Item.getProtein()*conversion_size;
		Carbs = Item.getCarbs()*conversion_size;
		Sugars = Item.getSugars()*conversion_size;
		Fiber = Item.getFiber()*conversion_size;
		Fat = Item.getFat()*conversion_size;
		Fatty_acids_sat = Item.getFatty_acids_sat()*conversion_size;
		Fatty_acids_mon = Item.getFatty_acids_mon()*conversion_size;
		Fatty_acids_pol = Item.getFatty_acids_pol()*conversion_size;
		Cholesterol = Item.getCholesterol()*conversion_size;
		Retinol = Item.getRetinol()*conversion_size;
		Vitamin_A = Item.getVitamin_A()*conversion_size;
		Carotene_al = Item.getCarotene_al()*conversion_size;
		Carotene_be = Item.getCarotene_be()*conversion_size;
		Cryptoxanthin = Item.getCryptoxanthin()*conversion_size;
		Lycopene = Item.getLycopene()*conversion_size;
		Lutein_with_zeaxanthin = Item.getLutein_with_zeaxanthin()*conversion_size;
		Thiamin = Item.getThiamin()*conversion_size;
		Riboflavin = Item.getRiboflavin()*conversion_size;
		Niacin = Item.getNiacin()*conversion_size;
		Vitamin_B6 = Item.getVitamin_B6()*conversion_size;
		Folic_acid = Item.getFolic_acid()*conversion_size;
		Folate_food = Item.getFolate_food()*conversion_size;
		Folate_DFE = Item.getFolate_DFE()*conversion_size;
		Folate_total = Item.getFolate_total()*conversion_size;
		Choline = Item.getCholine()*conversion_size;
		Vitamin_B12 = Item.getVitamin_B12()*conversion_size;
		Vitamin_B12_added = Item.getVitamin_B12_added()*conversion_size;
		Vitamin_C = Item.getVitamin_C()*conversion_size;
		Vitamin_D = Item.getVitamin_D()*conversion_size;
		Vitamin_E = Item.getVitamin_E()*conversion_size;
		Vitamin_E_added = Item.getVitamin_E_added()*conversion_size;
		Vitamin_K = Item.getVitamin_K()*conversion_size;
		Calcium = Item.getCalcium()*conversion_size;
		Phosphorus = Item.getPhosphorus()*conversion_size;
		Magnesium = Item.getMagnesium()*conversion_size;
		Iron = Item.getIron()*conversion_size;
		Zinc = Item.getZinc()*conversion_size;
		Copper = Item.getCopper()*conversion_size;
		Selenium = Item.getSelenium()*conversion_size;
		Potassium = Item.getPotassium()*conversion_size;
		Sodium = Item.getSodium()*conversion_size;
		Caffeine = Item.getCaffeine()*conversion_size;
		Theobromine = Item.getTheobromine()*conversion_size;
		Alcohol = Item.getAlcohol()*conversion_size;
		Water = Item.getWater()*conversion_size;
	}
	public Food getItem() {
		return Item;
	}
	public void setItem(Food item) {
		Item = item;
	}
	public double getPortion_size() {
		return Portion_size;
	}
	public void setPortion_size(double portion_size) {
		if(portion_size != 0) {
			Portion_size = portion_size;
			conversion_DEFAULT = Portion_DEFAULT/portion_size;
			conversion_size = portion_size/Portion_DEFAULT;
		}
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public String getDescription() {
		return Description;
	}
	public double getCalories() {
		return Calories;
	}
	public double getProtein() {
		return Protein;
	}
	public double getCarbs() {
		return Carbs;
	}
	public double getSugars() {
		return Sugars;
	}
	public double getFiber() {
		return Fiber;
	}
	public double getFat() {
		return Fat;
	}
	public double getFatty_acids_sat() {
		return Fatty_acids_sat;
	}
	public double getFatty_acids_mon() {
		return Fatty_acids_mon;
	}
	public double getFatty_acids_pol() {
		return Fatty_acids_pol;
	}
	public double getCholesterol() {
		return Cholesterol;
	}
	public double getRetinol() {
		return Retinol;
	}
	public double getVitamin_A() {
		return Vitamin_A;
	}
	public double getCarotene_al() {
		return Carotene_al;
	}
	public double getCryptoxanthin() {
		return Cryptoxanthin;
	}
	public double getCarotene_be() {
		return Carotene_be;
	}
	public double getLycopene() {
		return Lycopene;
	}
	public double getLutein_with_zeaxanthin() {
		return Lutein_with_zeaxanthin;
	}
	public double getThiamin() {
		return Thiamin;
	}
	public double getRiboflavin() {
		return Riboflavin;
	}
	public double getNiacin() {
		return Niacin;
	}
	public double getVitamin_B6() {
		return Vitamin_B6;
	}
	public double getFolic_acid() {
		return Folic_acid;
	}
	public double getFolate_food() {
		return Folate_food;
	}
	public double getFolate_DFE() {
		return Folate_DFE;
	}
	public double getFolate_total() {
		return Folate_total;
	}
	public double getCholine() {
		return Choline;
	}
	public double getVitamin_B12() {
		return Vitamin_B12;
	}
	public double getVitamin_B12_added() {
		return Vitamin_B12_added;
	}
	public double getVitamin_C() {
		return Vitamin_C;
	}
	public double getVitamin_D() {
		return Vitamin_D;
	}
	public double getVitamin_E() {
		return Vitamin_E;
	}
	public double getVitamin_E_added() {
		return Vitamin_E_added;
	}
	public double getVitamin_K() {
		return Vitamin_K;
	}
	public double getCalcium() {
		return Calcium;
	}
	public double getPhosphorus() {
		return Phosphorus;
	}
	public double getMagnesium() {
		return Magnesium;
	}
	public double getIron() {
		return Iron;
	}
	public double getZinc() {
		return Zinc;
	}
	public double getCopper() {
		return Copper;
	}
	public double getSelenium() {
		return Selenium;
	}
	public double getPotassium() {
		return Potassium;
	}
	public double getSodium() {
		return Sodium;
	}
	public double getCaffeine() {
		return Caffeine;
	}
	public double getTheobromine() {
		return Theobromine;
	}
	public double getAlcohol() {
		return Alcohol;
	}
	public double getWater() {
		return Water;
	}
	public void set_new_ID(int ID_new) {
		Item = new Food(Item.getTABLE_NAME(), ID_new);
		get_Food_to_size();
	}
	public void setName(String name) {
		Name = name;
		Item.setName(name);
	}
	public void setDescription(String description) {
		Description = description;
		Item.setDescription(description);
	}
	public void setCalories(double calories) {
		Calories = calories;
		Item.setCalories(calories*conversion_DEFAULT);
	}
	public void setProtein(double protein) {
		Protein = protein;
		Item.setProtein(protein*conversion_DEFAULT);
	}
	public void setCarbs(double carbs) {
		Carbs = carbs;
		Item.setCarbs(carbs*conversion_DEFAULT);
	}
	public void setSugars(double sugars) {
		Sugars = sugars;
		Item.setSugars(sugars*conversion_DEFAULT);
	}
	public void setFiber(double fiber) {
		Fiber = fiber;
		Item.setFiber(fiber*conversion_DEFAULT);
	}
	public void setFat(double fat) {
		Fat = fat;
		Item.setFat(fat*conversion_DEFAULT);
	}
	public void setFatty_acids_sat(double fatty_acids_sat) {
		Fatty_acids_sat = fatty_acids_sat;
		Item.setFatty_acids_sat(fatty_acids_sat*conversion_DEFAULT);
	}
	public void setFatty_acids_mon(double fatty_acids_mon) {
		Fatty_acids_mon = fatty_acids_mon;
		Item.setFatty_acids_mon(fatty_acids_mon*conversion_DEFAULT);
	}
	public void setFatty_acids_pol(double fatty_acids_pol) {
		Fatty_acids_pol = fatty_acids_pol;
		Item.setFatty_acids_pol(fatty_acids_pol*conversion_DEFAULT);
	}
	public void setCholesterol(double cholesterol) {
		Cholesterol = cholesterol;
		Item.setCholesterol(cholesterol*conversion_DEFAULT);
	}
	public void setRetinol(double retinol) {
		Retinol = retinol;
		Item.setRetinol(retinol*conversion_DEFAULT);
	}
	public void setVitamin_A(double vitamin_A) {
		Vitamin_A = vitamin_A;
		Item.setVitamin_A(vitamin_A*conversion_DEFAULT);
	}
	public void setCarotene_al(double carotene_al) {
		Carotene_al = carotene_al;
		Item.setCarotene_al(carotene_al*conversion_DEFAULT);
	}
	public void setCryptoxanthin(double cryptoxanthin) {
		Cryptoxanthin = cryptoxanthin;
		Item.setCryptoxanthin(cryptoxanthin*conversion_DEFAULT);
	}
	public void setCarotene_be(double carotene_be) {
		Carotene_be = carotene_be;
		Item.setCarotene_be(carotene_be*conversion_DEFAULT);
	}
	public void setLycopene(double lycopene) {
		Lycopene = lycopene;
		Item.setLycopene(lycopene*conversion_DEFAULT);
	}
	public void setLutein_with_zeaxanthin(double lutein_with_zeaxanthin) {
		Lutein_with_zeaxanthin = lutein_with_zeaxanthin;
		Item.setLutein_with_zeaxanthin(lutein_with_zeaxanthin*conversion_DEFAULT);
	}
	public void setThiamin(double thiamin) {
		Thiamin = thiamin;
		Item.setThiamin(thiamin*conversion_DEFAULT);
	}
	public void setRiboflavin(double riboflavin) {
		Riboflavin = riboflavin;
		Item.setRiboflavin(riboflavin*conversion_DEFAULT);
	}
	public void setNiacin(double niacin) {
		Niacin = niacin;
		Item.setNiacin(niacin*conversion_DEFAULT);
	}
	public void setVitamin_B6(double vitamin_B6) {
		Vitamin_B6 = vitamin_B6;
		Item.setVitamin_B6(vitamin_B6*conversion_DEFAULT);
	}
	public void setFolic_acid(double folic_acid) {
		Folic_acid = folic_acid;
		Item.setFolic_acid(folic_acid*conversion_DEFAULT);
	}
	public void setFolate_food(double folate_food) {
		Folate_food = folate_food;
		Item.setFolate_food(folate_food*conversion_DEFAULT);
	}
	public void setFolate_DFE(double folate_DFE) {
		Folate_DFE = folate_DFE;
		Item.setFolate_DFE(folate_DFE*conversion_DEFAULT);
	}
	public void setFolate_total(double folate_total) {
		Folate_total = folate_total;
		Item.setFolate_total(folate_total*conversion_DEFAULT);
	}
	public void setCholine(double choline) {
		Choline = choline;
		Item.setCholine(choline*conversion_DEFAULT);
	}
	public void setVitamin_B12(double vitamin_B12) {
		Vitamin_B12 = vitamin_B12;
		Item.setVitamin_B12(vitamin_B12*conversion_DEFAULT);
	}
	public void setVitamin_B12_added(double vitamin_B12_added) {
		Vitamin_B12_added = vitamin_B12_added;
		Item.setVitamin_B12_added(vitamin_B12_added*conversion_DEFAULT);
	}
	public void setVitamin_C(double vitamin_C) {
		Vitamin_C = vitamin_C;
		Item.setVitamin_C(vitamin_C*conversion_DEFAULT);
	}
	public void setVitamin_D(double vitamin_D) {
		Vitamin_D = vitamin_D;
		Item.setVitamin_D(vitamin_D*conversion_DEFAULT);
	}
	public void setVitamin_E(double vitamin_E) {
		Vitamin_E = vitamin_E;
		Item.setVitamin_E(vitamin_E*conversion_DEFAULT);
	}
	public void setVitamin_E_added(double vitamin_E_added) {
		Vitamin_E_added = vitamin_E_added;
		Item.setVitamin_E_added(vitamin_E_added*conversion_DEFAULT);
	}
	public void setVitamin_K(double vitamin_K) {
		Vitamin_K = vitamin_K;
		Item.setVitamin_K(vitamin_K*conversion_DEFAULT);
	}
	public void setCalcium(double calcium) {
		Calcium = calcium;
		Item.setCalcium(calcium*conversion_DEFAULT);
	}
	public void setPhosphorus(double phosphorus) {
		Phosphorus = phosphorus;
		Item.setPhosphorus(phosphorus*conversion_DEFAULT);
	}
	public void setMagnesium(double magnesium) {
		Magnesium = magnesium;
		Item.setMagnesium(magnesium*conversion_DEFAULT);
	}
	public void setIron(double iron) {
		Iron = iron;
		Item.setIron(iron*conversion_DEFAULT);
	}
	public void setZinc(double zinc) {
		Zinc = zinc;
		Item.setZinc(zinc*conversion_DEFAULT);
	}
	public void setCopper(double copper) {
		Copper = copper;
		Item.setCopper(copper*conversion_DEFAULT);
	}
	public void setSelenium(double selenium) {
		Selenium = selenium;
		Item.setSelenium(selenium*conversion_DEFAULT);
	}
	public void setPotassium(double potassium) {
		Potassium = potassium;
		Item.setPotassium(potassium*conversion_DEFAULT);
	}
	public void setSodium(double sodium) {
		Sodium = sodium;
		Item.setSodium(sodium*conversion_DEFAULT);
	}
	public void setCaffeine(double caffeine) {
		Caffeine = caffeine;
		Item.setCaffeine(caffeine*conversion_DEFAULT);
	}
	public void setTheobromine(double theobromine) {
		Theobromine = theobromine;
		Item.setTheobromine(theobromine*conversion_DEFAULT);
	}
	public void setAlcohol(double alcohol) {
		Alcohol = alcohol;
		Item.setAlcohol(alcohol*conversion_DEFAULT);
	}
	public void setWater(double water) {
		Water = water;
		Item.setWater(water*conversion_DEFAULT);
	}
    public String toString() {
    	DecimalFormat df = new DecimalFormat();
    	df.setMaximumFractionDigits(4);
        return "\n"
        		+ "***************************"  + "\n"
        		+"ID: "+ getID() + "\n"
        		+"Name: "+ getName() + "\n"
        		+"Calories: "+ df.format(getCalories()) + "\n"	
        		+"Protein: "+ df.format(getProtein()) + "\n"	
        		+"Carbs: "+ df.format(getCarbs()) + "\n"
        		+"Sugars: "+ df.format(getSugars()) + "\n"
        		+"Fiber: "+ df.format(getFiber()) + "\n"
        		+"Fat: " + df.format(getFat())  + "\n"
        		+"***************************"  + "\n"
        		;
    }
}
