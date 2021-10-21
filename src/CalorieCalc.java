
public class CalorieCalc 
{
    public double calorieConverter(int tr, int tw, int aw, int dci) 
    {
        int dw = tw - aw;
        if(dw == 0)
        {
            return 0;
        }
        if (dw < 0)
        {
            int cta = Math.abs(dw) * 3594;
            double cpd = cta / tr;
            return dci - cpd;
        } 
        else 
        {
            int cta = dw *2750;
            double cpd = cta / tr;
            double cit = cpd - dci;
            return dci + Math.abs(cit);
        }
    }
}
