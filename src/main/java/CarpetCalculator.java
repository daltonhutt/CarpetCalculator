import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CarpetCalculator implements Calculatable{
    private float pricePerSquareFoot;
    private Float installationFee;
    private float total;
    private String totalCost;
    private float discPrice;
    private float percentDiscount;
    private float perDiscTotal;
    private ArrayList<Room> room;
    private int area;

    public CarpetCalculator(float pricePerSquareFoot) {
        this.room = new ArrayList<Room>();
        this.pricePerSquareFoot = pricePerSquareFoot;
    }
    public CarpetCalculator(float pricePerSquareFoot, float installationFee) {
        this.room = new ArrayList<Room>();
        this.pricePerSquareFoot = pricePerSquareFoot;
        this.installationFee = installationFee;
    }
    public void addRoom(Room room) {
        this.room.add(room);
    }
    public void addPercentDiscount(float percentDiscount) {
        this.perDiscTotal = perDiscTotal/100;
        this.percentDiscount = percentDiscount;
        if (percentDiscount != 0.0F) {
            perDiscTotal = (total - (total * percentDiscount));
        }
    }
    public String getTotalCost() {
        for (Room room : room) {
            total = (total + pricePerSquareFoot * room.getLengthOfRoom() * room.getWidthOfRoom());
        }
        if (installationFee != null) {
            total = total + installationFee;
        }
        return moneyAlt(this.total);
    }


    public String moneyAlt(float number) {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String s = n.format(number);
        return s;
    }

}
