package inventory.category.application.dto.request;

public class CategoryRq {

    private String name;
    private String description;

    public CategoryRq() {
    }

    public CategoryRq(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
