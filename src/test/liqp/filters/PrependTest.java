package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrependTest {

    @Test
    public void applyTest() throws RecognitionException {

        String[][] tests = {
                {"{{ 'a' | prepend: 'b' }}", "ba"},
                {"{{ '' | prepend: '' }}", ""},
                {"{{ 1 | prepend: 23 }}", "231"},
                {"{{ nil | prepend: 'a' }}", "a"},
                {"{{ nil | prepend: nil }}", ""},
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render());

            assertThat(rendered, is(test[1]));
        }
    }
}