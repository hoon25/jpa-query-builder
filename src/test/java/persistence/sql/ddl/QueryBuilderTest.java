package persistence.sql.ddl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueryBuilderTest {

    @Test
    @DisplayName("@Entity 클래스의 create 쿼리 만들기")
    void makeCreateQuery() {
        QueryBuilder queryBuilder = new QueryBuilder();

        String query = queryBuilder.generateCreate(Person.class);

        assertThat(query).isEqualTo("""
                create table Person
                (
                    id bigint,
                    name varchar(255),
                    age int,
                    primary key (id)
                );
                """);
    }
}