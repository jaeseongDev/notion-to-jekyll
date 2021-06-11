package parser;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MarkdownParserTest {
    @Test
    public void removeAsteriskInCodeBlock() {
        String text = "```\n"
            + "code block **test** code block\n"
            + "```\n";
        String title = "제목";
        String categories = "분류";
        String tags = "태그";
        MarkdownParser parser = new MarkdownParser(text);

        String removedAsteriskText = parser.parse(title, categories, tags);

        String expectedText = "---\n"
            + "layout: post\n"
            + "title:  \"" + title + "\"\n"
            + "subtitle: \"" + title + "\"\n"
            + "categories: " + categories + "\n"
            + "tags: " + tags + "\n"
            + "comments: false\n"
            + "---\n" + "```\n"
            + "code block test code block\n"
            + "```\n";
        assertThat(removedAsteriskText).isEqualTo(expectedText);
    }
}