package persistence.sql.ddl.builder;

import persistence.sql.ddl.clause.Drop;
import persistence.sql.ddl.dialect.Dialect;

public class DropQueryBuilder implements QueryBuilder {
    private final Dialect dialect;

    public DropQueryBuilder(Dialect dialect) {
        this.dialect = dialect;
    }

    @Override
    public String generateSQL(final Class<?> clazz) {
        return String.format("drop table %s;", new Drop(clazz, dialect).getTableName());
    }
}
