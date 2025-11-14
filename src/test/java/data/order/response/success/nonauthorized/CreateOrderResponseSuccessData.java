package data.order.response.success.nonauthorized;

import data.order.response.success.nonauthorized.elements.ElementOrder;

public class CreateOrderResponseSuccessData {

    private Boolean success;
    private ElementOrder order;
    private String name;

    public CreateOrderResponseSuccessData(Boolean success, ElementOrder order, String name) {
        this.success = success;
        this.order = order;
        this.name = name;
    }

    public CreateOrderResponseSuccessData() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ElementOrder getOrder() {
        return order;
    }

    public void setOrder(ElementOrder order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
