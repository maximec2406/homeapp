package ru.homeapp.web;

public class AddBookCompleteBean {
    private String partId;
    private String title;
    private String supplierName;

    public AddBookCompleteBean(String partId, String title, String supplierName) {
        this.partId = partId;
        this.title = title;
        this.supplierName = supplierName;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
