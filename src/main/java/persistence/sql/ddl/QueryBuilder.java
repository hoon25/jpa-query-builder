package persistence.sql.ddl;

public interface QueryBuilder {
    String generateSQL(final Class<?> clazz);
}
