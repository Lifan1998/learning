package behavior.snapshot;

import java.util.Scanner;

/**
 * @author fan.li
 * @web https://www.lifan.org.cn
 * @date 2021-03-31
 * @description
 *
 * 假设有这样一道面试题，希望你编写一个小程序，可以接收命令行的输入。
 * 用户输入文本时，程序将其追加存储在内存文本中；用户输入“:list”，程序在命令行中输出内存文本的内容；
 * 用户输入“:undo”，程序会撤销上一次输入的文本，也就是从内存文本中将上次输入的文本删除掉。
 *
 */

public class AppMain {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputContentCache contentCache = new InputContentCache();

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (":list".equals(inputLine)) {
                System.out.println(contentCache.content);
                continue;
            }

            if (":undo".equals(inputLine)) {
                contentCache.undo();
                continue;
            }

            contentCache.appendContent(inputLine);
        }
    }


    /**
     * 仅支持追加模式与一次撤销
     */
    public static class InputContentCache {
        private StringBuilder content;
        private String lastContent;

        private String appendContent(String line) {
            lastContent = line;
            return content.append(line).toString();
        }

        private String getContent() {
            return content.toString();
        }

        private void undo() {
            content.replace(content.length() - lastContent.length(), content.length(), null);
        }

    }


    public static class InputContentCache0 {
        private StringBuilder content = new StringBuilder();
        /**
         * 上次文本的最新值
         */
        private String lastContent;

        private String appendContent(String line) {
            // 追加文本时保留上次快照
            lastContent = content.toString();
            return content.append(line).toString();
        }

        private String getContent() {
            return content.toString();
        }

        /**
         * 支持来回撤销，支持中间插入，但不支持撤销多次输入
         */
        private void undo() {
            String temp = content.toString();
            content = new StringBuilder(lastContent);
            lastContent = temp;
        }

    }

    /**
     * 支持多次撤销，支持中间插入
     */
    public static class InputContentCache1 {
        private StringBuilder content = new StringBuilder();
        /**
         * 上次文本的最新值
         */
        private String lastContent;

        private String appendContent(String line) {
            // 追加文本时保留上次快照
            lastContent = content.toString();
            return content.append(line).toString();
        }

        private String getContent() {
            return content.toString();
        }

        /**
         * 支持来回撤销，支持中间插入，但不支持撤销多次输入
         */
        private void undo() {
            String temp = content.toString();
            content = new StringBuilder(lastContent);
            lastContent = temp;
        }

    }
}

