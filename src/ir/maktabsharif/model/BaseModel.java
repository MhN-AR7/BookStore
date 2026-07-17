package ir.maktabsharif.model;

import java.util.Objects;

public abstract class BaseModel<ID> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        BaseModel<?> baseModel = (BaseModel<?>) object;
        return Objects.equals(id, baseModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
