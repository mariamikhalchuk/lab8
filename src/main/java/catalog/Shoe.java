package catalog;

public class Shoe {
    private String name;
    private String type;
    private String color;
    private int size;
    private String material;
    private String manufacturer;


    public Shoe(String name, String type, String color, int size, String material, String manufacturer) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.size = size;
        this.material = material;
        this.manufacturer = manufacturer;
    }

    public Shoe(String name, String type, String manufacturer) {
        this.name = name;
        this.type = type;
        this.color = "Black";
        this.size = 40;
        this.material = "Leather";
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
