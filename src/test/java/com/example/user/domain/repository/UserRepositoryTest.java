package com.example.user.domain.repository;

import com.github.database.rider.core.api.dataset.DataSetFormat;
import com.github.database.rider.core.api.exporter.ExportDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@DBRider
class UserRepositoryTest {

    @Autowired
    private UserRepository userTest;

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/user_exist.json")
    void checkThatUserExist() {
        boolean val = userTest.findOne("admin@email.com") != null;

        assertThat(val).isEqualTo(true);

    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/repository/user_not_exist.json")
    void checkThatUserDoesNotExist() {
        boolean val = userTest.findOne("joshi@josh.com") != null;

        assertThat(val).isEqualTo(false);

    }


}