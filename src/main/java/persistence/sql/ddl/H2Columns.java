package persistence.sql.ddl;

import java.lang.reflect.Field;
import java.util.List;

public class H2Columns {
    private final List<H2Column> columns;

    public H2Columns(List<Field> fields) {
        this.columns = fields.stream().map(H2Column::new).toList();
    }

    public String generateSQL() {
        StringBuilder sb = new StringBuilder();
        columns.forEach(h2Column -> {
            sb.append("    ");
            sb.append(h2Column.generateColumnSQL());
            sb.append(",\n");
        });
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}