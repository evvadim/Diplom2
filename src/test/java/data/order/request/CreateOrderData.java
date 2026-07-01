package data.order.request;

import java.util.List;

public class CreateOrderData {

    private List<String> ingredients;

    public CreateOrderData(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public CreateOrderData() {
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

}
