package com.example.user.domain.repository;

import com.example.user.SpringBootBaseTest;
import com.github.database.rider.core.api.dataset.DataSetFormat;
import com.github.database.rider.core.api.exporter.ExportDataSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserRepositoryTest extends SpringBootBaseTest {

    @Autowired
    private UserRepository userTest;

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/user_exist.json")
    void checkThatUserExist() {
        boolean val = userTest.findUserByEmail("admin@email.com") != null;

        assertThat(val).isEqualTo(true);

    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/repository/user_not_exist.json")
    void checkThatUserDoesNotExist() {
        boolean val = userTest.findUserByEmail("joshi@josh.com") != null;

        assertThat(val).isEqualTo(false);

    }


}