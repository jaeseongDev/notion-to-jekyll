package parser;

import java.util.UUID;

public class MarkdownParser {
    private static final int CODE_BLOCK_DELIMITER_MIN_COUNT_WHEN_CODE_BLOCK_EXISTS = 2;
    private static final String CODE_BLOCK_DELIMITER = "```";

    private final String text;

    public MarkdownParser(String text) {
        this.text = text;
    }

    public String parse(String title, String categories, String tags) {
        return removeAsteriskInCodeBlock()
            .addJekyllTitleText(title, categories, tags)
            .text;
    }

    private MarkdownParser removeAsteriskInCodeBlock() {
        String[] splitTexts = text.split(CODE_BLOCK_DELIMITER);
        if (splitTexts.length > CODE_BLOCK_DELIMITER_MIN_COUNT_WHEN_CODE_BLOCK_EXISTS) {
            for (int i = 0; 2 * i + 1 < splitTexts.length; i++) {
                splitTexts[2 * i + 1] = splitTexts[2 * i + 1].replace("**", "");
            }
        }
        return new MarkdownParser(String.join(CODE_BLOCK_DELIMITER, splitTexts));
    }

    private MarkdownParser addJekyllTitleText(String title, String categories, String tags) {
        String titleText = "---\n"
            + "layout: post\n"
            + "title:  \"" + title + "\"\n"
            + "subtitle: \"" + title + "\"\n"
            + "categories: " + categories + "\n"
            + "tags: " + tags + "\n"
            + "comments: false\n"
            + "---\n";
        return new MarkdownParser(titleText + text);
    }
}
