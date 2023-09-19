package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    ACTION(1),IN_ACTIVE(0),TERMINATED(-1);

    private int value;

    ProductStatus(int value){
        this.value=value;
    }

    public int value() {
        return value;
    }
}
