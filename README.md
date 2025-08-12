


![Java Version](https://img.shields.io/badge/Java-11%2B-orange.svg)

A simple, lightweight, zero-dependency command-line tool written in Java to convert basic Markdown files to clean, styled HTML5. This project is a great introduction to text parsing, regular expressions, and file I/O.



***

## How It Works

This tool functions as a simple text processor that reads a source file, translates its content, and writes to a destination file. The process is straightforward:

1.  **File Access:** The program is run from your terminal. You must provide the name of the Markdown file you want to convert as a **command-line argument**. For example: `java MarkdownConverter my-document.md`.

2.  **Reading:** The tool accesses the specified file (`my-document.md`) and reads its entire content into memory, line by line.

3.  **Parsing:** It then iterates through each line, applying a set of rules to translate Markdown syntax (like `#` for headers or `**` for bold) into the corresponding HTML tags (like `<h1>` or `<strong>`).

4.  **Writing:** Finally, it creates a **new file** in the same directory. The new file will have the same name as the original but with an `.html` extension (e.g., `my-document.html`). This file contains the fully converted and styled HTML content.

***

## Features

* **Headers:** Supports `<h1>`, `<h2>`, and `<h3>`.
* **Inline Formatting:** Handles **bold** and *italic* text.
* **Links:** Parses `[link text](url)` into clickable HTML links.
* **Horizontal Rules:** Converts `---` into an `<hr>` tag.
* **Clean Output:** Generates semantic HTML5 with embedded CSS for a modern, readable look.

***

## Getting Started

Follow these instructions to run the converter on your own machine.

### Prerequisites

You must have the **Java Development Kit (JDK) version 11 or newer** installed. You can check your version with the command:
```sh
java -version
````

### Execution Steps

1.  **Save the Code:** Save the Java code into a file named `MarkdownConverter.java`.

2.  **Prepare a Markdown File:** Create a sample Markdown file in the same directory. For this example, let's name it `sample.md`.

3.  **Open Your Terminal:** Navigate to the directory where you saved the files.

4.  **Compile the Java Code:**

    ```sh
    javac MarkdownConverter.java
    ```

5.  **Run the Converter:** Execute the program, passing your Markdown file's name as an argument.

    ```sh
    java MarkdownConverter sample.md
    ```

    After running the command, a new file named `sample.html` will appear in your directory. You can open this HTML file in any web browser to see the final, formatted result.

-----

## Technologies Used

  * **Java 11+**
  * **Java NIO Library (`java.nio.file`)** for modern file reading and writing.
  * **Regular Expressions (Regex)** for finding and replacing inline formatting patterns.

-----


```
```
