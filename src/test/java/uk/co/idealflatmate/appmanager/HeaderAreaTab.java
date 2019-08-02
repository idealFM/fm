package uk.co.idealflatmate.appmanager;

public class HeaderAreaTab {
    private  String select1;
    private  String select2;
    private  String area;

    public HeaderAreaTab withSelect1(String select1) {
        this.select1 = select1;
        return this;
    }

    public HeaderAreaTab withSelect2(String select2) {
        this.select2 = select2;
        return this;
    }

    public HeaderAreaTab withArea(String area) {
        this.area = area;
        return this;
    }



    public String getSelect1() {
        return select1;
    }

    public String getSelect2() {
        return select2;
    }

    public String getArea() {
        return area;
    }
}
