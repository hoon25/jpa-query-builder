package persistence.sql.ddl.h2.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persistence.domain.Person;
import persistence.sql.ddl.QueryBuilder;

import static org.assertj.core.api.Assertions.assertThat;

class CreateQueryBuilderTest {

    @Test
    @DisplayName("@Entity 클래스의 create 쿼리 만들기")
    void makeCreateQuery() {
        QueryBuilder createQueryBuilder = new CreateQueryBuilder();

        String query = createQueryBuilder.generateSQL(Person.class);

        assertThat(query).isEqualTo(
                "create table users\n" +
                        "(\n" +
                        "    id bigint NOT NULL generated by default as identity,\n" +
                        "    nick_name varchar(255) NULL,\n" +
                        "    old int NULL,\n" +
                        "    email varchar(255) NOT NULL,\n" +
                        "    primary key (id)\n" +
                        ");\n");
    }
}