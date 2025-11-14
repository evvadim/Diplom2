package data.ingredients.response.success;

import data.ingredients.response.success.elements.IngredientData;

import java.util.List;

public class GetIngredientsResponseSuccessData {

    private Boolean success;
    private List<IngredientData> data;

    public GetIngredientsResponseSuccessData(Boolean success, List<IngredientData> data) {
        this.success = success;
        this.data = data;
    }

    public GetIngredientsResponseSuccessData() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<IngredientData> getData() {
        return data;
    }

    public void setData(List<IngredientData> data) {
        this.data = data;
    }

}
