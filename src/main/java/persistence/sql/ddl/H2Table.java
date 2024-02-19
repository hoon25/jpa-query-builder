package persistence.sql.ddl;

import jakarta.persistence.Table;

public class H2Table {
    private final Class<?> clazz;

    public H2Table(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getTableName() {
        if (!hasTableAnnotation()) {
            return getTableNameByClass();
        }
        String annotationName = clazz.getAnnotation(Table.class).name();
        if (annotationName.isBlank()) {
            return getTableNameByClass();
        }
        return annotationName;
    }

    private String getTableNameByClass() {
        return clazz.getSimpleName();
    }

    private boolean hasTableAnnotation() {
        return clazz.isAnnotationPresent(Table.class);
    }
}