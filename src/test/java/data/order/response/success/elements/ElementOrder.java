package data.order.response.success.elements;

import data.ingredients.response.success.elements.IngredientData;
import data.user.common.elements.OwnerData;

import java.util.List;

public class ElementOrder {

    private List<IngredientData> ingredients;
    private String _id;
    private OwnerData owner;
    private String status;
    private String name;
    private String createdAt;
    private String updatedAt;
    private Integer number;
    private Integer price;

    public ElementOrder(List<IngredientData> ingredients,
                        String _id,
                        OwnerData owner,
                        String status,
                        String name,
                        String createdAt,
                        String updatedAt,
                        Integer number,
                        Integer price) {
        this.ingredients = ingredients;
        this._id = _id;
        this.owner = owner;
        this.status = status;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.number = number;
        this.price = price;
    }

    public ElementOrder() {
    }

    public List<IngredientData> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientData> ingredients) {
        this.ingredients = ingredients;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public OwnerData getOwner() {
        return owner;
    }

    public void setOwner(OwnerData owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
