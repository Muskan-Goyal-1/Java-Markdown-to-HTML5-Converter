import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MarkdownConverter {

    public static void main(String[] args) {
        // 1. Check for correct command-line arguments
        if (args.length != 1) {
            System.out.println("Usage: java MarkdownConverter <input.md>");
            return;
        }

        String markdownFileName = args[0];
        if (!markdownFileName.endsWith(".md")) {
            System.out.println("Error: Input file must be a .md file.");
            return;
        }

        Path inputPath = Paths.get(markdownFileName);
        String htmlFileName = markdownFileName.substring(0, markdownFileName.length() - 3) + ".html";
        Path outputPath = Paths.get(htmlFileName);

        // 2. Read, convert, and write the file
        try {
            List<String> markdownLines = Files.readAllLines(inputPath);
            List<String> htmlLines = convertMarkdownToHtml(markdownLines);
            Files.write(outputPath, htmlLines);
            System.out.println("Successfully converted " + markdownFileName + " to " + htmlFileName);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    private static List<String> convertMarkdownToHtml(List<String> markdownLines) {
        List<String> htmlLines = new ArrayList<>();
        
        // Add HTML boilerplate and basic CSS styling
        htmlLines.add("<!DOCTYPE html>");
        htmlLines.add("<html lang=\"en\">");
        htmlLines.add("<head>");
        htmlLines.add("    <meta charset=\"UTF-8\">");
        htmlLines.add("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        htmlLines.add("    <title>Markdown</title>");
        htmlLines.add("    <style>");
        htmlLines.add("        body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif; line-height: 1.6; color: #333; max-width: 800px; margin: 40px auto; padding: 0 20px; }");
        htmlLines.add("        h1, h2, h3 { border-bottom: 1px solid #ddd; padding-bottom: 5px; }");
        htmlLines.add("        code { background-color: #f6f8fa; padding: 2px 4px; border-radius: 3px; font-family: monospace; }");
        htmlLines.add("        a { color: #0366d6; text-decoration: none; }");
        htmlLines.add("        a:hover { text-decoration: underline; }");
        htmlLines.add("    </style>");
        htmlLines.add("</head>");
        htmlLines.add("<body>");

        // Process each line of Markdown
        for (String line : markdownLines) {
            String htmlLine;
            if (line.startsWith("###")) {
                htmlLine = "<h3>" + parseInlineFormatting(line.substring(4).trim()) + "</h3>";
            } else if (line.startsWith("##")) {
                htmlLine = "<h2>" + parseInlineFormatting(line.substring(3).trim()) + "</h2>";
            } else if (line.startsWith("#")) {
                htmlLine = "<h1>" + parseInlineFormatting(line.substring(2).trim()) + "</h1>";
            } else if (line.startsWith("---")) {
                htmlLine = "<hr>";
            } else if (line.trim().isEmpty()) {
                continue; // Skip empty lines
            } else {
                htmlLine = "<p>" + parseInlineFormatting(line) + "</p>";
            }
            htmlLines.add(htmlLine);
        }

        // Add closing HTML tags
        htmlLines.add("</body>");
        htmlLines.add("</html>");

        return htmlLines;
    }

    private static String parseInlineFormatting(String line) {
        // Order of replacement matters!
        // 1. Links: [text](url) -> <a href="url">text</a>
        line = line.replaceAll("\\[(.*?)\\]\\((.*?)\\)", "<a href=\"$2\">$1</a>");
        // 2. Bold: **text** -> <strong>text</strong>
        line = line.replaceAll("\\*\\*(.*?)\\*\\*", "<strong>$1</strong>");
        // 3. Italic: *text* -> <em>text</em>
        line = line.replaceAll("\\*(.*?)\\*", "<em>$1</em>");
        return line;
    }
}