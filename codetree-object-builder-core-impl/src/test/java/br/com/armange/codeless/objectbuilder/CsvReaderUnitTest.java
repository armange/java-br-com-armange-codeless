package br.com.armange.codeless.objectbuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.armange.codeless.core.StringUtil;
import br.com.armange.codeless.objectbuilder.artifacts.FakeCity;
import br.com.armange.codeless.objectbuilder.csv.CsvLine;

@Ignore
public class CsvReaderUnitTest {

    private static final String ID_PROPERTY_NAME = "id";
    private static final String CSV_FILE_NAME = "fakeCity.csv";

    @Test
    public void importCsvAndNotConvertIt() {
        try {
            final InputStream resourceAsStream = Thread
                    .currentThread().getContextClassLoader().getResourceAsStream(CSV_FILE_NAME);
            
            final List<CsvLine> lines = ObjectBuilder
                .ofInputStream(resourceAsStream)
                .ofCsv(StringUtil.COMMA, true)
                .stream()
                .collect(Collectors.toList());
            
            final SoftAssertions softAssertions = new SoftAssertions();
            
            softAssertions.assertThat(lines).isNotNull();
            softAssertions.assertThat(lines).isNotEmpty();
            softAssertions.assertThat(lines.size()).isEqualTo(4);
            
            softAssertions.assertAll();
        } catch (final IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void importCsvAndConvertIt() {
        try {
            final InputStream resourceAsStream = Thread
                    .currentThread().getContextClassLoader().getResourceAsStream(CSV_FILE_NAME);
            
            final List<FakeCity> lines = ObjectBuilder
                .ofInputStream(resourceAsStream)
                .ofCsv(StringUtil.COMMA, true)
                .streamAs(FakeCity.class)
                .collect(Collectors.toList());
            
            final SoftAssertions softAssertions = new SoftAssertions();
            
            softAssertions.assertThat(lines).isNotNull();
            softAssertions.assertThat(lines).isNotEmpty();
            softAssertions.assertAll();
            
            Assert.assertThat(lines, Matchers.hasSize(4));
            Assert.assertThat(lines, Matchers.allOf(
                    Matchers.hasItems(Matchers.hasProperty(ID_PROPERTY_NAME, Matchers.equalTo(1))),
                    Matchers.hasItems(Matchers.hasProperty(ID_PROPERTY_NAME, Matchers.equalTo(2))),
                    Matchers.hasItems(Matchers.hasProperty(ID_PROPERTY_NAME, Matchers.equalTo(3))),
                    Matchers.hasItems(Matchers.hasProperty(ID_PROPERTY_NAME, Matchers.equalTo(4)))
                ));
            
        } catch (final IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
