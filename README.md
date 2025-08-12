# Java_Markdown_to_HTML5_Converter
A simple, lightweight, zero-dependency command-line tool written in Java to convert basic Markdown files into clean, styled HTML5.
# Java Markdown to HTML Converter ☕

![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)
![Java Version](https://img.shields.io/badge/Java-11%2B-orange.svg)

A simple, lightweight, zero-dependency command-line tool written in Java to convert basic Markdown files into clean, styled HTML5. This project serves as a great introduction to text parsing, regular expressions, and file I/O in Java.



***

## Features

* **Headers:** Supports `<h1>`, `<h2>`, and `<h3>` using `#`, `##`, and `###`.
* **Inline Formatting:** Handles **bold** (`**text**`) and *italic* (`*text*`) styling.
* **Links:** Correctly parses Markdown links (`[text](url)`) into HTML anchor tags.
* **Horizontal Rules:** Converts `---` into an `<hr>` tag.
* **Clean Output:** Generates semantic HTML5 with embedded CSS for a modern, readable look.
* **Zero Dependencies:** Runs on a standard Java installation without needing any external libraries.

***

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

You will need the Java Development Kit (JDK) version 11 or newer installed on your system. You can verify your installation by running:
```sh
java -version
